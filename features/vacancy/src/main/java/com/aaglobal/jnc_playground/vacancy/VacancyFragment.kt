package com.aaglobal.jnc_playground.vacancy

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.aaglobal.jnc_playground.vacancy.di.VacancyDI
import kotlinx.android.synthetic.main.fragment_vacancy.*
import kotlin.random.Random


class VacancyFragment : Fragment(R.layout.fragment_vacancy) {

    companion object {
        private const val LOG_TAG = "VacancyFragment"
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // We lose possibility to use delegation `navArgs` =(
        val vacancyId = arguments?.getString("vacancyId")!!

        Log.d(LOG_TAG, "onViewCreated | args: $vacancyId")

        fragment_vacancy__text__title.text = getString(R.string.fragment_vacancy__title, vacancyId)

        fragment_vacancy__button__next_vacancy.setOnClickListener {
            // We lose possibility to use `*Directions` classes
            VacancyDI.vacancyRouterSource?.openNextVacancy("${vacancyId}+${Random.nextInt(10)}")
        }

        fragment_vacancy__button__open_company_flow.setOnClickListener {
            VacancyDI.vacancyRouterSource?.openCompanyFlow()
        }
    }

}
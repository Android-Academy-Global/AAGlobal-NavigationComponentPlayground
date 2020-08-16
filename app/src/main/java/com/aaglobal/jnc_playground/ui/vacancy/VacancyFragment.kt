package com.aaglobal.jnc_playground.ui.vacancy

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.aaglobal.jnc_playground.R
import kotlinx.android.synthetic.main.fragment_vacancy.*
import kotlin.random.Random


class VacancyFragment : Fragment(R.layout.fragment_vacancy) {

    companion object {
        private const val LOG_TAG = "VacancyFragment"
    }


    private val args: VacancyFragmentArgs by navArgs()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d(LOG_TAG, "onViewCreated | args: $args")

        fragment_vacancy__text__title.text = getString(R.string.fragment_vacancy__title, args.vacancyId)

        fragment_vacancy__button__next_vacancy.setOnClickListener {
            findNavController().navigate(
                VacancyFragmentDirections.actionVacancyFragmentToVacancyFragment(vacancyId = "${args.vacancyId}+${Random.nextInt(10)}")
            )
        }
    }

}
package com.aaglobal.jnc_playground.ui.tabs.favorites

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.aaglobal.jnc_playground.R
import com.aaglobal.jnc_playground.core.utils.addFragmentLossIfNotExist
import com.aaglobal.jnc_playground.di.GlobalDI
import com.aaglobal.jnc_playground.ui.vacancy_list.VacancyListFragment
import com.aaglobal.jnc_playground.ui.vacancy_list.VacancyListRouterSource
import com.aaglobal.jnc_playground.ui.vacancy_list.adapter.VacancyItem
import com.aaglobal.jnc_playground.vacancy.VacancyFragmentArgs
import kotlinx.android.synthetic.main.fragment_favorites_container.*


class FavoritesContainerFragment : Fragment(R.layout.fragment_favorites_container) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragment_favorites_container__button__open_dialogs.setOnClickListener {
            findNavController().navigate(R.id.action__FavoritesContainerFragment__to__ABottomSheet)
        }
        addVacancyListFragment()
    }


    private fun addVacancyListFragment() {
        addFragmentLossIfNotExist(
            fragmentManager = childFragmentManager,
            containerViewId = R.id.fragment_favorites_container__container__recommend_vacancies,
            fragment = VacancyListFragment.newInstance(
                vacancyType = "favorites_container",
                vacancyListRouterSource = object : VacancyListRouterSource {
                    override fun navigateToVacancyScreen(item: VacancyItem) {
                        GlobalDI.initVacancyDI(findNavController())

                        findNavController().navigate(
                            R.id.action__FavoritesContainerFragment__to__VacancyFragment,
                            VacancyFragmentArgs(vacancyId = "${item.name}|${item.id}").toBundle()
                        )
                    }
                }
            )
        )
    }

}
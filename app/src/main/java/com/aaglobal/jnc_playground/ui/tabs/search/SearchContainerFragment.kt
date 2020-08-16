package com.aaglobal.jnc_playground.ui.tabs.search

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.aaglobal.jnc_playground.R
import com.aaglobal.jnc_playground.company.CompanyDetailsFragment.Companion.COMPANY_FLOW_RESULT_FLAG
import com.aaglobal.jnc_playground.company.di.CompanyDI
import com.aaglobal.jnc_playground.company.routing.CompanyFragmentDetailsRouterSource
import com.aaglobal.jnc_playground.company.routing.CompanyFragmentRouterSource
import com.aaglobal.jnc_playground.core.utils.addFragmentLossIfNotExist
import com.aaglobal.jnc_playground.ui.vacancy.VacancyFragmentArgs
import com.aaglobal.jnc_playground.ui.vacancy_list.VacancyListFragment
import com.aaglobal.jnc_playground.ui.vacancy_list.VacancyListRouterSource
import com.aaglobal.jnc_playground.ui.vacancy_list.adapter.VacancyItem
import kotlinx.android.synthetic.main.fragment_search_container.*


class SearchContainerFragment : Fragment(R.layout.fragment_search_container) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Read result from nested navigation flow
        val companyFlowResult = findNavController().currentBackStackEntry
            ?.savedStateHandle
            ?.remove<Boolean>(COMPANY_FLOW_RESULT_FLAG)
        fragment_search_container__text__company_flow_result.text = getString(
            R.string.fragment_search_container__company_flow_result, companyFlowResult?.toString()
        )

        fragment_search_container__button__open_company_flow.setOnClickListener {
            // We need to init interfaces for routing
            initCompanyDI()
            // And only after that we can go into module navigation
            findNavController().navigate(R.id.action__SearchContainerFragment__to__CompanyFlow)
        }

        addVacancyListFragment()
    }


    private fun addVacancyListFragment() {
        addFragmentLossIfNotExist(
            fragmentManager = childFragmentManager,
            containerViewId = R.id.fragment_search_container__container__recommend_vacancies,
            fragment = VacancyListFragment.newInstance(
                vacancyType = "search_container",
                vacancyListRouterSource = object : VacancyListRouterSource {
                    override fun navigateToVacancyScreen(item: VacancyItem) {
                        findNavController().navigate(
                            R.id.action__SearchContainerFragment__to__VacancyFragment,
                            VacancyFragmentArgs(vacancyId = "${item.name}|${item.id}").toBundle()
                        )
                    }
                }
            )
        )
    }


    private fun initCompanyDI() {
        CompanyDI.companyFragmentRouterSource = object : CompanyFragmentRouterSource {
            override fun moveToCompanyDetails() {
                findNavController().navigate(R.id.action__CompanyFragment__to__CompanyDetailsFragment)
            }
        }
        CompanyDI.companyFragmentDetailsRouterSource = object : CompanyFragmentDetailsRouterSource {
            override fun finishCompanyFlow(flowResult: Boolean) {
                // Here we are inside nested navigation flow
                findNavController().popBackStack(R.id.company_flow__nav_graph, true)

                // At this line, "findNavController().currentBackStackEntry" means screen that STARTED current nested flow.
                // So we can send result!
                findNavController().currentBackStackEntry?.savedStateHandle?.set(COMPANY_FLOW_RESULT_FLAG, true)
            }
        }
    }

}
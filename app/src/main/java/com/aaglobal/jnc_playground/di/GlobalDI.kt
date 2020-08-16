package com.aaglobal.jnc_playground.di

import android.content.Context
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.aaglobal.jnc_playground.R
import com.aaglobal.jnc_playground.company.CompanyDetailsFragment
import com.aaglobal.jnc_playground.company.di.CompanyDI
import com.aaglobal.jnc_playground.company.routing.CompanyFragmentDetailsRouterSource
import com.aaglobal.jnc_playground.company.routing.CompanyFragmentRouterSource
import com.aaglobal.jnc_playground.domain.AuthRepository
import com.aaglobal.jnc_playground.ui.vacancy_list.VacancyListRouterSource
import com.aaglobal.jnc_playground.vacancy.VacancyFragmentDirections
import com.aaglobal.jnc_playground.vacancy.di.VacancyDI
import com.aaglobal.jnc_playground.vacancy.routing.VacancyRouterSource


/**
 * Singleton for "DI" in our example app
 */
object GlobalDI {

    private val vacancyListRouterSourcesMap = mutableMapOf<String, VacancyListRouterSource>()

    private lateinit var applicationContext: Context


    fun initWithContext(applicationContext: Context) {
        this.applicationContext = applicationContext
    }

    fun getAuthRepository(): AuthRepository {
        return AuthRepository(applicationContext)
    }

    fun putVacancyListRouterSource(vacancyListType: String, routerSource: VacancyListRouterSource) {
        vacancyListRouterSourcesMap[vacancyListType] = routerSource
    }

    fun fetchVacancyListRouterSource(vacancyListType: String): VacancyListRouterSource? {
        return vacancyListRouterSourcesMap[vacancyListType]
    }

    fun removeVacancyListRouterSource(vacancyListType: String) {
        vacancyListRouterSourcesMap.remove(vacancyListType)
    }


    fun initCompanyDI(navController: NavController) {
        CompanyDI.companyFragmentRouterSource = object : CompanyFragmentRouterSource {
            override fun moveToCompanyDetails() {
                navController.navigate(R.id.action__CompanyFragment__to__CompanyDetailsFragment)
            }
        }
        CompanyDI.companyFragmentDetailsRouterSource = object : CompanyFragmentDetailsRouterSource {
            override fun finishCompanyFlow(flowResult: Boolean) {
                // Here we are inside nested navigation flow
                navController.popBackStack(R.id.company_flow__nav_graph, true)

                // At this line, "navController.currentBackStackEntry" means screen that STARTED current nested flow.
                // So we can send result!
                navController.currentBackStackEntry?.savedStateHandle?.set(CompanyDetailsFragment.COMPANY_FLOW_RESULT_FLAG, true)
            }
        }
    }
    
    fun initVacancyDI(navController: NavController) {
        VacancyDI.vacancyRouterSource = object : VacancyRouterSource {
            override fun openNextVacancy(vacancyId: String) {
                navController.navigate(
                    VacancyFragmentDirections.actionVacancyFragmentToVacancyFragment(vacancyId = vacancyId)
                )
            }

            override fun openCompanyFlow() {
                initCompanyDI(navController)
                navController.navigate(R.id.action__VacancyFragment__to__CompanyFlow)
            }
        }
    }

}
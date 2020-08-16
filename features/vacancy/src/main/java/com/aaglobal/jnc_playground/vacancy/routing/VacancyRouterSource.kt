package com.aaglobal.jnc_playground.vacancy.routing


interface VacancyRouterSource {

    fun openNextVacancy(vacancyId: String)

    fun openCompanyFlow()

}
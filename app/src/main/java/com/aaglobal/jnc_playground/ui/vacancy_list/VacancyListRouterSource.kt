package com.aaglobal.jnc_playground.ui.vacancy_list

import com.aaglobal.jnc_playground.ui.vacancy_list.adapter.VacancyItem


interface VacancyListRouterSource {

    fun navigateToVacancyScreen(item: VacancyItem)

}
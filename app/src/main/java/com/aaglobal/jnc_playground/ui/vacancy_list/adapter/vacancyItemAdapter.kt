package com.aaglobal.jnc_playground.ui.vacancy_list.adapter

import com.aaglobal.jnc_playground.R
import com.aaglobal.jnc_playground.core.ui.DisplayableItem
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateLayoutContainer
import kotlinx.android.synthetic.main.item__vacancy.*


fun vacancyItemAdapter(
    clickListener: (VacancyItem) -> Unit
) = adapterDelegateLayoutContainer<VacancyItem, DisplayableItem>(R.layout.item__vacancy) {

    item_vacancy__container.setOnClickListener {
        clickListener.invoke(item)
    }


    bind {
        item_vacancy__text__name.text = context.getString(R.string.fragment_vacancy_list__item__name, item.name, item.id)
    }
}
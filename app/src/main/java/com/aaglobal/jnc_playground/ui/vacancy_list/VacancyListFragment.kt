package com.aaglobal.jnc_playground.ui.vacancy_list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.aaglobal.jnc_playground.di.GlobalDI
import com.aaglobal.jnc_playground.R
import com.aaglobal.jnc_playground.core.ui.DisplayableItem
import com.aaglobal.jnc_playground.ui.vacancy_list.adapter.VacancyItem
import com.aaglobal.jnc_playground.ui.vacancy_list.adapter.vacancyItemAdapter
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import kotlinx.android.synthetic.main.fragment_vacancy_list.*


class VacancyListFragment : Fragment(R.layout.fragment_vacancy_list) {

    companion object {
        private const val ARGS_VACANCY_LIST_TYPE = "args_type"

        fun newInstance(vacancyType: String, vacancyListRouterSource: VacancyListRouterSource): VacancyListFragment {
            GlobalDI.putVacancyListRouterSource(vacancyType, vacancyListRouterSource)

            return VacancyListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARGS_VACANCY_LIST_TYPE, vacancyType)
                }
            }
        }
    }


    private val delegationAdapter by lazy {
        ListDelegationAdapter<List<DisplayableItem>>(
            vacancyItemAdapter {
                routerSource.navigateToVacancyScreen(it)
            }
        )
    }

    private val vacancyListType: String get() = requireArguments().getString(ARGS_VACANCY_LIST_TYPE).orEmpty()
    private val routerSource: VacancyListRouterSource by lazy { requireNotNull(GlobalDI.fetchVacancyListRouterSource(vacancyListType)) }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragment_vacancy_list__text__title.text = vacancyListType

        with(fragment_vacancy_list__recycler) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = delegationAdapter
        }

        delegationAdapter.items = IntRange(0, 3).map { index ->
            VacancyItem(
                id = "$index",
                name = "$vacancyListType vac"
            )
        }
        delegationAdapter.notifyDataSetChanged()
    }


}
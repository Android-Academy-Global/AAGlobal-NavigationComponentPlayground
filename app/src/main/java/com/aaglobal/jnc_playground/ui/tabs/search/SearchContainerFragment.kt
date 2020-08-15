package com.aaglobal.jnc_playground.ui.tabs.search

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.aaglobal.jnc_playground.R
import com.aaglobal.jnc_playground.ui.company.CompanyDetailsFragment
import kotlinx.android.synthetic.main.fragment_search_container.*


class SearchContainerFragment : Fragment(R.layout.fragment_search_container) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Read result from nested navigation flow
        val companyFlowResult = findNavController().currentBackStackEntry
            ?.savedStateHandle
            ?.remove<Boolean>(CompanyDetailsFragment.COMPANY_FLOW_RESULT_FLAG)
        fragment_search_container__text__company_flow_result.text = getString(
            R.string.fragment_search_container__company_flow_result, companyFlowResult?.toString()
        )

        fragment_search_container__button__open_company_flow.setOnClickListener {
            findNavController().navigate(R.id.action__SearchContainerFragment__to__CompanyFlow)
        }
    }

}
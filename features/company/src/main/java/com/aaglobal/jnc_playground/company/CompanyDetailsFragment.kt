package com.aaglobal.jnc_playground.company

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_company_details.*


class CompanyDetailsFragment : Fragment(R.layout.fragment_company_details) {

    companion object {
        const val COMPANY_FLOW_RESULT_FLAG = "company_flow_result"
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // We use defined graph in feature-module
        fragment_company_details__button.setOnClickListener {
            // Here we are inside nested navigation flow
            findNavController().popBackStack(R.id.company_flow__nav_graph, true)

            // At this line, "navController.currentBackStackEntry" means screen that STARTED current nested flow.
            // So we can send result!
            findNavController().currentBackStackEntry?.savedStateHandle?.set(COMPANY_FLOW_RESULT_FLAG, true)
        }
    }

}
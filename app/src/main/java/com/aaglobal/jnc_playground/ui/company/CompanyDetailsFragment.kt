package com.aaglobal.jnc_playground.ui.company

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.aaglobal.jnc_playground.R
import kotlinx.android.synthetic.main.fragment_company_details.*


class CompanyDetailsFragment : Fragment(R.layout.fragment_company_details) {

    companion object {
        const val COMPANY_FLOW_RESULT_FLAG = "company_flow_result"
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /**
         * To return on screen that started this flow, we use `popBackStack` function.
         *
         * Such method allows us don't think about propagating "start" screen @id
         */
        fragment_company_details__button.setOnClickListener {
            findNavController().popBackStack(R.id.company_flow__nav_graph, true)
            findNavController().currentBackStackEntry?.savedStateHandle?.set(COMPANY_FLOW_RESULT_FLAG, true)
        }
    }

}
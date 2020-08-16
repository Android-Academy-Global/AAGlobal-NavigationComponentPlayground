package com.aaglobal.jnc_playground.company

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.aaglobal.jnc_playground.company.di.CompanyDI
import kotlinx.android.synthetic.main.fragment_company_details.*


class CompanyDetailsFragment : Fragment(R.layout.fragment_company_details) {

    companion object {
        const val COMPANY_FLOW_RESULT_FLAG = "company_flow_result"
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // We use special interface for navigating from this module
        fragment_company_details__button.setOnClickListener {
            CompanyDI.companyFragmentDetailsRouterSource?.finishCompanyFlow(flowResult = true)

        }
    }

}
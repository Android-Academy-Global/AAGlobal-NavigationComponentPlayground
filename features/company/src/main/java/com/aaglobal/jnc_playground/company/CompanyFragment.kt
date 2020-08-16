package com.aaglobal.jnc_playground.company

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.aaglobal.jnc_playground.company.di.CompanyDI
import kotlinx.android.synthetic.main.fragment_company.*


class CompanyFragment : Fragment(R.layout.fragment_company) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // We use special interface for navigating from this module
        fragment_company__button.setOnClickListener {
            CompanyDI.companyFragmentRouterSource?.moveToCompanyDetails()
        }
    }

}
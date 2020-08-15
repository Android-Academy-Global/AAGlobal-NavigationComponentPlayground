package com.aaglobal.jnc_playground.ui.tabs.responses

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.aaglobal.jnc_playground.R
import kotlinx.android.synthetic.main.fragment_responses_container.*


class ResponsesContainerFragment : Fragment(R.layout.fragment_responses_container) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragment_responses_container__button__open_company_flow.setOnClickListener {
            findNavController().navigate(R.id.action__ResponsesContainerFragment__to__CompanyFlow)
        }
    }

}
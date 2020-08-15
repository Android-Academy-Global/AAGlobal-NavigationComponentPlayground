package com.aaglobal.jnc_playground.ui.auth

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.aaglobal.jnc_playground.R
import kotlinx.android.synthetic.main.fragment_finish_auth.*


class FinishAuthFragment : Fragment(R.layout.fragment_finish_auth) {

    companion object {
        const val AUTH_FLOW_RESULT_KEY = "auth_flow_result"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragment_finish_auth__button.setOnClickListener {
            findNavController().popBackStack(R.id.auth__nav_graph, true)

            findNavController().currentBackStackEntry?.savedStateHandle?.set(AUTH_FLOW_RESULT_KEY, true)
        }
    }

}
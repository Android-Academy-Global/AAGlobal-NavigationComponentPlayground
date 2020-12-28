package com.aaglobal.jnc_playground.ui.auth

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.aaglobal.jnc_playground.R
import kotlinx.android.synthetic.main.fragment_finish_auth.*


class FinishAuthFragment : Fragment(R.layout.fragment_finish_auth) {

    private val finishAuthViewModel: FinishAuthViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragment_finish_auth__button.setOnClickListener {
            // Save hasAuthData flag in prefs
            finishAuthViewModel.setFinishAuthFlag()

            // Navigate back from auth flow
            val result = findNavController().popBackStack(R.id.auth__nav_graph, true)
            if (result.not()) {
                // we can't open new destination with this action
                // --> we opened Auth flow from splash
                // --> need to open main graph
                findNavController().navigate(R.id.MainFragment)
            }
        }
    }

}
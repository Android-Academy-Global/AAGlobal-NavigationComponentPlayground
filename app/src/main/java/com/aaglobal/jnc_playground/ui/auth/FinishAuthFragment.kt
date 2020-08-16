package com.aaglobal.jnc_playground.ui.auth

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.aaglobal.jnc_playground.R
import kotlinx.android.synthetic.main.fragment_finish_auth.*


class FinishAuthFragment : Fragment(R.layout.fragment_finish_auth) {

    companion object {
        const val AUTH_FLOW_RESULT_KEY = "auth_flow_result"
    }

    private val finishAuthViewModel: FinishAuthViewModel by viewModels()

    private var callback: OnBackPressedCallback? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragment_finish_auth__button.setOnClickListener {
            // Save hasAuthData flag in prefs
            finishAuthViewModel.setFinishAuthFlag()

            // Navigate back from auth flow
            Navigation.findNavController(
                requireActivity(),
                R.id.activity_root__fragment__nav_host
            ).popBackStack(R.id.auth__nav_graph, true)

            // Send signal about finishing flow
            findNavController().currentBackStackEntry?.savedStateHandle?.set(AUTH_FLOW_RESULT_KEY, true)
        }

        callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                Navigation.findNavController(
                    requireActivity(),
                    R.id.activity_root__fragment__nav_host
                ).popBackStack()
            }
        }.also {
            requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, it)
        }
    }

    override fun onDestroyView() {
        callback?.remove()
        super.onDestroyView()
    }

}
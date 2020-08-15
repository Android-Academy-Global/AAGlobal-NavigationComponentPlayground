package com.aaglobal.jnc_playground.ui.auth

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.aaglobal.jnc_playground.R
import kotlinx.android.synthetic.main.fragment_start_auth.*

class StartAuthFragment : Fragment(R.layout.fragment_start_auth) {

    private var callback: OnBackPressedCallback? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragment_start_auth__button.setOnClickListener {
            findNavController().navigate(R.id.action__StartAuthFragment__to__FinishAuthFragment)
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
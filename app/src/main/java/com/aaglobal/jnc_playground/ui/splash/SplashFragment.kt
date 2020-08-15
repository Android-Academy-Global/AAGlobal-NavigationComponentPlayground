package com.aaglobal.jnc_playground.ui.splash

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.aaglobal.jnc_playground.R


class SplashFragment : Fragment(R.layout.fragment_splash) {

    private val splashViewModel: SplashViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        splashViewModel.isInProgress.observe(viewLifecycleOwner, Observer { isInProgress ->
            if (isInProgress.not()) {
                findNavController().navigate(R.id.action__SplashFragment__to__MainFragment)
            }
        })
    }

}
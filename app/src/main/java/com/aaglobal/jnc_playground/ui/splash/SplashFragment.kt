package com.aaglobal.jnc_playground.ui.splash

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.aaglobal.jnc_playground.R
import com.aaglobal.jnc_playground.ui.auth.StartAuthFragmentArgs


class SplashFragment : Fragment(R.layout.fragment_splash) {

    private val splashViewModel: SplashViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Navigate with SingleLiveEvent from Splash screen
        splashViewModel.splashNavCommand.observe(viewLifecycleOwner, Observer { splashNavCommand ->
            when (splashNavCommand) {
                SplashNavCommand.NAVIGATE_TO_MAIN -> navigateToMainScreen()
                SplashNavCommand.NAVIGATE_TO_AUTH -> navigateToAuthFlow()
                null -> {
                    // do nothing
                }
            }
        })
    }

    private fun navigateToAuthFlow() {
        findNavController().navigate(R.id.action__SplashFragment__to__AuthFlow, StartAuthFragmentArgs(isFromSplashScreen = true).toBundle())
    }

    private fun navigateToMainScreen() {
        findNavController().navigate(R.id.action__SplashFragment__to__MainFragment)
    }
}
package com.aaglobal.jnc_playground.ui.splash

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.aaglobal.jnc_playground.R


class SplashFragment : Fragment(R.layout.fragment_splash) {

    private val splashViewModel: SplashViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Navigate with SingleLiveEvent from Splash screen
        splashViewModel.splashNavCommand.observe(viewLifecycleOwner, Observer { splashNavCommand ->
            val navController = Navigation.findNavController(requireActivity(), R.id.activity_root__fragment__nav_host)

            val mainGraph = navController.navInflater.inflate(R.navigation.app_nav_graph)

            // Way to change first screen at runtime.
            mainGraph.startDestination = when (splashNavCommand) {
                SplashNavCommand.NAVIGATE_TO_MAIN -> R.id.MainFragment
                SplashNavCommand.NAVIGATE_TO_AUTH -> R.id.auth__nav_graph
                null -> throw IllegalArgumentException("Illegal splash navigation command")
            }

            navController.graph = mainGraph
        })
    }

}
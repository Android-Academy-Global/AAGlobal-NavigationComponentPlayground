package com.aaglobal.jnc_playground.ui.main

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.aaglobal.jnc_playground.R
import com.aaglobal.jnc_playground.extensions.setupWithNavController
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * Main fragment -- container for bottom navigation
 */
class MainFragment : Fragment(R.layout.fragment_main) {

    private var currentNavController: LiveData<NavController>? = null


    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        // Now that BottomNavigationBar has restored its instance state
        // and its selectedItemId, we can proceed with setting up the
        // BottomNavigationBar with Navigation
        safeSetupBottomNavigationBar()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState == null) {
            safeSetupBottomNavigationBar()
        }
    }

    private fun safeSetupBottomNavigationBar() {
        // Fix for java.lang.IllegalStateException: FragmentManager is already executing transactions
        // on launching adb command with deep link
        Handler().post {
            setupBottomNavigationBar()
        }
    }

    /**
     * Called on first creation and when restoring state.
     */
    private fun setupBottomNavigationBar() {
        val navGraphIds = listOf(
            R.navigation.search__nav_graph,
            R.navigation.favorites__nav_graph,
            R.navigation.responses__nav_graph,
            R.navigation.profile__nav_graph
        )

        // Setup the bottom navigation view with a list of navigation graphs
        val controller = fragment_main__bottom_navigation.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = requireActivity().supportFragmentManager,
            containerId = R.id.fragment_main__nav_host_container,
            intent = requireActivity().intent
        )

        currentNavController = controller

        // Fix for crash on app folding (will be crashed in onDestroyView of NavHostFragment, if you use 'Don't keep activities' mode).
        //
        // Caused by: java.lang.IllegalStateException:
        // View androidx.fragment.app.FragmentContainerView{1595b6 V.E...... ......ID 0,0-1080,1584 #7f080099 app:id/fragment_main__nav_host_container}
        // does not have a NavController set
        currentNavController?.observe(viewLifecycleOwner, Observer { liveDataController ->
            Navigation.setViewNavController(requireView(), liveDataController)
        })
    }


}
package com.aaglobal.jnc_playground.ui.dashboard

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.aaglobal.jnc_playground.R
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    private val dashboardViewModel: DashboardViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
            fragment_dashboard__text__title.text = it
        })

        // ========= Problem 1 =========
        // When we move to another bottom navigation tab, our counter will be reset!
        dashboardViewModel.counter.observe(viewLifecycleOwner, Observer {
            fragment_dashboard__text__counter.text = "$it"
        })
        fragment_dashboard__text__counter.setOnClickListener { dashboardViewModel.incCounter() }

        // ========= Problem 2 =========
        // When we change screen state and tap on bottom navigation tab - state of the screen will be reset!
        fragment_dashboard__button__move.setOnClickListener {
            findNavController().navigate(R.id.action__DashboardFragment_to_GraphicFragment)
        }
    }

}
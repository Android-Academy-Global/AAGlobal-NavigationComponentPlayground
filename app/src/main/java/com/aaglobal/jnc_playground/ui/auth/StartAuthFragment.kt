package com.aaglobal.jnc_playground.ui.auth

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.aaglobal.jnc_playground.R
import kotlinx.android.synthetic.main.fragment_start_auth.*

class StartAuthFragment : Fragment(R.layout.fragment_start_auth) {

    private val args: StartAuthFragmentArgs by navArgs()

    private var callback: OnBackPressedCallback? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragment_start_auth__button.setOnClickListener {
            findNavController().navigate(R.id.action__StartAuthFragment__to__FinishAuthFragment)
        }

        // After navigation from inner graph (MainFragment) into external (AuthFragment) you will see this:
        //
        // java.lang.IllegalArgumentException: No view found for id 0x7f080099 (com.aaglobal.jnc_playground:id/fragment_main__nav_host_container)
        // for fragment NavHostFragment{f8f83be} (2f93b3a0-49f2-4aaf-ba68-0b6df4f9b496) id=0x7f080099 bottomNavigation#0}
        //
        // Because NavController by default will search container from inner graph.
        // So, you need to create your own OnBackPressedCallback to handle navigation properly.
        callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (args.isFromSplashScreen) {
                    // Hack for proper navigation from the first screen. Because we don't want to return to Splash screen.
                    requireActivity().finish()
                } else {
                    Navigation.findNavController(
                        requireActivity(),
                        R.id.activity_root__fragment__nav_host
                    ).popBackStack()
                }
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
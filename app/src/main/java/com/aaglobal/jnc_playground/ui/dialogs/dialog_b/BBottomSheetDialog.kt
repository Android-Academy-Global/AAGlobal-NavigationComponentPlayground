package com.aaglobal.jnc_playground.ui.dialogs.dialog_b

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.aaglobal.jnc_playground.R
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.dialog_b_bottom_sheet.*


class BBottomSheetDialog : BottomSheetDialogFragment() {

    companion object {
        private const val LOG_TAG = "BBottomSheetDialog"
    }


    private var callback: OnBackPressedCallback? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // But this will work ¯\_(ツ)_/¯
        return object : BottomSheetDialog(requireContext(), theme) {
            override fun onBackPressed() {
                Log.d(LOG_TAG, "onBackPressed catch when override onCreateDialog")
                moveToABottomSheetDialog()
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dialog_b_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dialog_b_bottom_sheet__button__return.setOnClickListener {
            moveToABottomSheetDialog()
        }

        // Not working as expected -- no back pressed callback in this dialog ¯\_(ツ)_/¯
        callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                Log.d(LOG_TAG, "Catch OnBackPressedCallback callback")
                moveToABottomSheetDialog()
            }
        }.also { requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, it) }
    }

    override fun onDestroyView() {
        callback?.remove()
        super.onDestroyView()
    }


    private fun moveToABottomSheetDialog() {
        findNavController().navigate(R.id.action__BBottomSheet__to__ABottomSheet)
    }

}
package com.aaglobal.jnc_playground.ui.dialogs.dialog_a

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.aaglobal.jnc_playground.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.dialog_a_bottom_sheet.*


class ABottomSheetDialog : BottomSheetDialogFragment() {

    private val viewModel: ABottomSheetDialogViewModel by viewModels()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dialog_a_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.counter.observe(viewLifecycleOwner, Observer { counter ->
            dialog_a_bottom_sheet__text__counter.text = getString(R.string.dialog_a_bottom_sheet__counter, counter)
        })

        dialog_a_bottom_sheet__button__increase_counter.setOnClickListener {
            viewModel.increaseCounter()
        }

        dialog_a_bottom_sheet__button__open_next_dialog.setOnClickListener {
            findNavController().navigate(R.id.action__ABottomSheet__to__BBottomSheet)
        }
    }

}
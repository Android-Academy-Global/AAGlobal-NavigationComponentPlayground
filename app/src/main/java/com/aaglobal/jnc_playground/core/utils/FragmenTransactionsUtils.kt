package com.aaglobal.jnc_playground.core.utils

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager


fun addFragmentLossIfNotExist(
    fragmentManager: FragmentManager,
    @IdRes
    containerViewId: Int,
    fragment: Fragment,
    executeNow: Boolean = true) {

    if (fragmentManager.findFragmentById(containerViewId) == null) {
        addFragmentLoss(fragmentManager, containerViewId, fragment, executeNow)
    }
}


private fun addFragmentLoss(
    fragmentManager: FragmentManager,
    containerViewId: Int,
    fragment: Fragment,
    executeNow: Boolean = true) {

    with(fragmentManager) {
        beginTransaction()
            .add(containerViewId, fragment)
            .commitAllowingStateLoss()

        if (executeNow) {
            executePendingTransactions()
        }
    }
}
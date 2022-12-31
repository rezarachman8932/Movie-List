package com.app.movielistapp.shared.dialog

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager

fun showCustomDialog(
    fragmentManager: FragmentManager,
    key: String,
    dialogFragment: DialogFragment
) {
    fragmentManager.let {
        dialogFragment.show(it, key)
    }
}
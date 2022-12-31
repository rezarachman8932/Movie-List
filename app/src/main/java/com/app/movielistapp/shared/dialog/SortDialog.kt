package com.app.movielistapp.shared.dialog

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.core.content.res.ResourcesCompat
import com.app.movielistapp.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.view_sort_bottom_dialog.*

class SortDialog(private val sortAction: Int?, private val topButtonCallback: (Int) -> Unit, private val bottomButtonCallback: (Int) -> Unit, private val cancelButtonCallback: () -> Unit): BottomSheetDialogFragment() {

    override fun getTheme(): Int = R.style.BottomSheetDialogTheme

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog = BottomSheetDialog(requireContext(), theme)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.view_sort_bottom_dialog, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        getLayoutBehavior()
        btn_top_sort_dialog.backgroundTintList = if (sortAction == 0) ResourcesCompat.getColorStateList(resources, R.color.black, null) else ResourcesCompat.getColorStateList(resources, R.color.white, null)
        btn_bottom_sort_dialog.backgroundTintList = if (sortAction == 1) ResourcesCompat.getColorStateList(resources, R.color.black, null) else ResourcesCompat.getColorStateList(resources, R.color.white, null)
        btn_top_sort_dialog.setOnClickListener {
            topButtonCallback.invoke(0)
            dismiss()
        }
        btn_bottom_sort_dialog.setOnClickListener {
            bottomButtonCallback.invoke(1)
            dismiss()
        }
        btn_cancel_sort_dialog.setOnClickListener {
            cancelButtonCallback.invoke()
            dismiss()
        }


    }

    private fun getLayoutBehavior(): BottomSheetBehavior<FrameLayout> {
        val bottomSheet = (dialog as BottomSheetDialog).findViewById<View>(com.google.android.material.R.id.design_bottom_sheet) as FrameLayout
        bottomSheet.layoutParams?.height = ViewGroup.LayoutParams.WRAP_CONTENT
        return BottomSheetBehavior.from(bottomSheet)
    }

}
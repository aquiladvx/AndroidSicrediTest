package dev.aquiladvx.testsicredi.common

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import dev.aquiladvx.testsicredi.common.extension.hideKeyboard

open class BaseFragment: Fragment() {

    private var progress: LoadingDialog? = null

    fun showLoading() {
        hideKeyboard(requireContext())

        try {
            if (progress == null) {
                progress = LoadingDialog()
                progress?.show(parentFragmentManager, "dialog")
            }
        } catch (e: Exception) {
            return
        }
    }

    fun hideLoading() {
        progress?.dismiss()
        progress = null
    }
}
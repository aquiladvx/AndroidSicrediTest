package dev.aquiladvx.testsicredi.common.extension

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment

fun Fragment.hideKeyboard(context: Context = requireContext(), view: View? = null) =
    (context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager).let {
        val binder = when (view) {
            null -> if (activity?.currentFocus != null) activity?.currentFocus else View(requireContext())
            else -> view
        }!!

        it.hideSoftInputFromWindow(binder.windowToken, 0)
    }

/**
 * Exibe o teclado
 */
fun Fragment.showKeyboard(context: Context = requireContext()) =
    (context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).let {
        it.toggleSoftInput(
            InputMethodManager.SHOW_FORCED,
            InputMethodManager.HIDE_IMPLICIT_ONLY
        )
    }
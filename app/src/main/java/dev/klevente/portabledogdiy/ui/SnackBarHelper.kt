package dev.klevente.portabledogdiy.ui

import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

fun Fragment.snackbar(message: String?, duration: Int = Snackbar.LENGTH_SHORT) {
    Snackbar.make(requireView(), message ?: "null", duration).show()
}

fun Fragment.snackbar(@StringRes resId: Int, duration: Int = Snackbar.LENGTH_SHORT) {
    Snackbar.make(requireView(), resId, duration).show()
}
package dev.klevente.portabledogdiy.ui.about

import androidx.fragment.app.Fragment
import dev.klevente.portabledogdiy.R

class AboutFragment : Fragment(R.layout.fragment_about) {

    override fun onResume() {
        super.onResume()
        throw RuntimeException("test")
    }
}
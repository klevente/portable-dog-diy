package dev.klevente.portabledogdiy.ui

import androidx.appcompat.widget.Toolbar
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.navigation.navigator
import dev.klevente.portabledogdiy.R
import dev.klevente.portabledogdiy.ui.about.AboutFragment

fun RainbowCakeFragment<*, *>.initToolbar(toolbar: Toolbar, title: String? = null) {
    toolbar.inflateMenu(R.menu.menu_main)

    toolbar.setOnMenuItemClickListener { item ->
        when (item.itemId) {
            R.id.action_view_about -> {
                navigator?.add(AboutFragment())
            }
        }
        true
    }

    if (title != null) {
        toolbar.title = title
    }
}
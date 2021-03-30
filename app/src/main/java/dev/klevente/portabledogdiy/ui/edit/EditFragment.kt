package dev.klevente.portabledogdiy.ui.edit

import android.os.Bundle
import android.view.View
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import dev.klevente.portabledogdiy.R

class EditFragment : RainbowCakeFragment<EditViewState, EditViewModel>() {

    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_edit

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        TODO("Not yet implemented")
    }

    override fun render(viewState: EditViewState) {
        TODO("Not yet implemented")
    }
}
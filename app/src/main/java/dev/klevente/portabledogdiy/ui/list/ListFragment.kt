package dev.klevente.portabledogdiy.ui.list

import android.os.Bundle
import android.view.View
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import dev.klevente.portabledogdiy.R

class ListFragment : RainbowCakeFragment<ListViewState, ListViewModel>() {

    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        TODO("Not yet implemented")
    }

    override fun render(viewState: ListViewState) {
        TODO("Not yet implemented")
    }
}
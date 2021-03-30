package dev.klevente.portabledogdiy.ui.detail

import android.os.Bundle
import android.view.View
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import dev.klevente.portabledogdiy.R


class DetailFragment : RainbowCakeFragment<DetailViewState, DetailViewModel>() {

    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_detail

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        TODO("Not yet implemented")
    }

    override fun render(viewState: DetailViewState) {
        TODO("Not yet implemented")
    }
}


package dev.klevente.portabledogdiy.ui.detail

import android.os.Bundle
import android.view.View
import co.zsmb.rainbowcake.base.OneShotEvent
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.extensions.exhaustive
import co.zsmb.rainbowcake.navigation.extensions.applyArgs
import co.zsmb.rainbowcake.navigation.extensions.requireInt
import co.zsmb.rainbowcake.navigation.navigator
import com.bumptech.glide.Glide
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase
import dev.klevente.portabledogdiy.R
import dev.klevente.portabledogdiy.ui.detail.DetailViewModel.DeleteFailedEvent
import dev.klevente.portabledogdiy.ui.detail.DetailViewModel.LoadFailedEvent
import dev.klevente.portabledogdiy.ui.edit.EditFragment
import dev.klevente.portabledogdiy.ui.format
import dev.klevente.portabledogdiy.ui.initToolbar
import dev.klevente.portabledogdiy.ui.snackbar
import kotlinx.android.synthetic.main.fragment_detail.*


class DetailFragment : RainbowCakeFragment<DetailViewState, DetailViewModel>() {

    companion object {
        private const val ARG_BEER_ID = "ARG_BEER_ID"

        fun newInstance(beerId: Int): DetailFragment {
            return DetailFragment().applyArgs {
                putInt(ARG_BEER_ID, beerId)
            }
        }
    }

    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_detail

    private var beerId: Int = -1

    private lateinit var maltAdapter: MaltAdapter
    private lateinit var hopAdapter: HopAdapter
    private lateinit var mashAdapter: MashAdapter

    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initArgs()

        btnDelete.setOnClickListener {
            viewModel.deleteBeer(beerId)
            firebaseAnalytics.logEvent("delete_beer") {
                param("beer_id", id.toString())
            }
        }

        btnEdit.setOnClickListener {
            navigator?.add(EditFragment.newInstance(beerId))
        }

        maltAdapter = MaltAdapter(requireContext())
        hopAdapter = HopAdapter(requireContext())
        mashAdapter = MashAdapter(requireContext())
        rvMalts.adapter = maltAdapter
        rvHops.adapter = hopAdapter
        rvMash.adapter = mashAdapter

        initToolbar(toolbar)

        firebaseAnalytics = Firebase.analytics

        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW) {
            param(FirebaseAnalytics.Param.SCREEN_NAME, toolbar.title.toString())
            param(FirebaseAnalytics.Param.SCREEN_CLASS, "DetailFragment")
        }
    }

    private fun initArgs() {
        beerId = requireArguments().requireInt(ARG_BEER_ID)
    }

    override fun onStart() {
        super.onStart()

        viewModel.loadBeer(beerId)
    }

    override fun render(viewState: DetailViewState) {
        when (viewState) {
            Loading -> { return }
            is DetailReady -> {
                val beer = viewState.beer

                toolbar.title = beer.name
                tvTagline.text = beer.tagline
                tvAbv.text = getString(R.string.abv_value, beer.abv)
                tvIbu.text = getString(R.string.ibu_value, beer.ibu)
                tvOg.text = getString(R.string.og_value, beer.og)
                tvFg.text = getString(R.string.fg_value, beer.fg)
                tvVolume.text = getString(R.string.volume_value, beer.volume.format())
                tvBoilVolume.text = getString(R.string.boil_volume_value, beer.boilVolume.format())
                tvYeast.text = getString(R.string.yeast_value, beer.yeast)
                tvDescription.text = beer.description
                maltAdapter.submitList(beer.malts)
                hopAdapter.submitList(beer.hops)
                mashAdapter.submitList(beer.mash)
                tvFermentation.text = getString(R.string.fermentation_value, beer.fermentationTemperature.format())


                Glide.with(ivThumbnailImage)
                    .load(beer.imageUrl)
                    .into(ivThumbnailImage)
            }
        }.exhaustive
    }

    override fun onEvent(event: OneShotEvent) {
        when (event) {
            LoadFailedEvent -> {
                snackbar(R.string.load_failed)
                navigator?.pop()
            }
            DeleteFailedEvent -> {
                snackbar(R.string.delete_failed)
            }
        }
    }
}


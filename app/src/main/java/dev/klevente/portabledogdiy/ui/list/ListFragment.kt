package dev.klevente.portabledogdiy.ui.list

import android.os.Bundle
import android.transition.TransitionManager
import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DividerItemDecoration
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.extensions.exhaustive
import co.zsmb.rainbowcake.navigation.navigator
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase
import dev.klevente.portabledogdiy.R
import dev.klevente.portabledogdiy.ui.detail.DetailFragment
import dev.klevente.portabledogdiy.ui.edit.EditFragment
import dev.klevente.portabledogdiy.ui.initToolbar
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment : RainbowCakeFragment<ListViewState, ListViewModel>(), BeerAdapter.Listener {

    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_list

    private lateinit var beerAdapter: BeerAdapter

    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        beerAdapter = BeerAdapter(requireContext())
        beerAdapter.listener = this
        beerList.adapter = beerAdapter
        beerList.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

        retryButton.setOnClickListener {
            viewModel.reload()
        }

        fabAddBeer.setOnClickListener {
            navigator?.add(EditFragment.newInstance())
        }


        initToolbar(toolbar)

        firebaseAnalytics = Firebase.analytics

        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW) {
            param(FirebaseAnalytics.Param.SCREEN_NAME, toolbar.title.toString())
            param(FirebaseAnalytics.Param.SCREEN_CLASS, "ListFragment")
        }
    }

    override fun render(viewState: ListViewState) {
        TransitionManager.beginDelayedTransition(listFragmentRoot)
        when (viewState) {
            Loading -> {
                loadingIndicator.isVisible = true
                normalGroup.isVisible = false
                errorGroup.isVisible = false
            }
            is ListReady -> {
                beerAdapter.submitList(viewState.beers)
                loadingIndicator.isVisible = false
                normalGroup.isVisible = true
                errorGroup.isVisible = false
            }
            Error -> {
                loadingIndicator.isVisible = false
                normalGroup.isVisible = false
                errorGroup.isVisible = true
            }
        }.exhaustive
    }

    override fun onBeerItemSelected(id: Int) {
        navigator?.add(DetailFragment.newInstance(id))
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM) {
            param(FirebaseAnalytics.Param.ITEM_ID, id.toString())
            param(FirebaseAnalytics.Param.CONTENT_TYPE, "beer")
        }
    }
}
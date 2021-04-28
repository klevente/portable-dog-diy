package dev.klevente.portabledogdiy.ui.edit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import co.zsmb.rainbowcake.base.OneShotEvent
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.navigation.extensions.applyArgs
import co.zsmb.rainbowcake.navigation.extensions.getIntOrNull
import co.zsmb.rainbowcake.navigation.navigator
import dev.klevente.portabledogdiy.R
import dev.klevente.portabledogdiy.databinding.FragmentEditBinding
import dev.klevente.portabledogdiy.domain.TemperatureUnit
import dev.klevente.portabledogdiy.ui.edit.EditViewModel.*
import dev.klevente.portabledogdiy.ui.snackbar
import timber.log.Timber

class EditFragment : RainbowCakeFragment<EditViewState, EditViewModel>() {

    companion object {
        private const val ARG_BEER_ID = "ARG_BEER_ID"

        fun newInstance(beerId: Int): EditFragment {
            return EditFragment().applyArgs {
                putInt(ARG_BEER_ID, beerId)
            }
        }

        fun newInstance() = EditFragment()
    }

    override fun provideViewModel() = getViewModelFromFactory()

    private var _binding: FragmentEditBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private var beerId: Int = -1

    private val editing: Boolean
        get() = beerId > 0

    private lateinit var maltAdapter: EditMaltAdapter
    private lateinit var hopAdapter: EditHopAdapter
    private lateinit var mashAdapter: EditMashAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initArgs()
        initAdapters()
        initAddListeners()

        if (editing) {
            binding.toolbar.title = "Edit Recipe"
        } else {
            binding.toolbar.title = "Add Recipe"
        }

        binding.spFermentationUnit.adapter = ArrayAdapter<TemperatureUnit>(
            context!!, android.R.layout.simple_list_item_1, TemperatureUnit.values()
        )

        binding.btnSave.setOnClickListener {
            Timber.d(binding.beer.toString())
            if (editing) {
                binding.beer?.let { viewModel.updateBeer(it) }
            } else {
                binding.beer?.let { viewModel.addNewBeer(it) }
            }
            navigator?.pop()
        }
        binding.btnCancel.setOnClickListener {
            navigator?.pop()
        }
    }

    private fun initArgs() {
        beerId = arguments?.getIntOrNull(ARG_BEER_ID) ?: -1
    }

    private fun initAdapters() {
        maltAdapter = EditMaltAdapter(requireContext())
        hopAdapter = EditHopAdapter(requireContext())
        mashAdapter = EditMashAdapter(requireContext())

        binding.rvMalts.adapter = maltAdapter
        binding.rvHops.adapter = hopAdapter
        binding.rvHops.addItemDecoration(
            DividerItemDecoration(
                context,
                DividerItemDecoration.VERTICAL
            )
        )
        binding.rvMash.adapter = mashAdapter
    }

    private fun initAddListeners() {
        binding.btnAddMalt.setOnClickListener {
            maltAdapter.addMalt()
        }
        binding.btnAddHop.setOnClickListener {
            hopAdapter.addHop()
        }
        binding.btnAddMash.setOnClickListener {
            mashAdapter.addMash()
        }
    }

    override fun onStart() {
        super.onStart()

        if (editing) {
            viewModel.loadBeer(beerId)
        } else {
            viewModel.createNewBeer()
        }
    }

    override fun render(viewState: EditViewState) {
        when (viewState) {
            Loading -> {
                return
            }
            is EditReady -> {
                val beer = viewState.beer
                binding.beer = beer
                maltAdapter.submitList(beer.malts)
                hopAdapter.submitList(beer.hops)
                mashAdapter.submitList(beer.mash)
            }
        }
    }

    override fun onEvent(event: OneShotEvent) {
        when (event) {
            LoadFailedEvent -> {
                snackbar(R.string.load_failed)
                navigator?.pop()
            }
            AddFailedEvent -> {
                snackbar(R.string.add_failed)
            }
            UpdateFailedEvent -> {
                snackbar(R.string.update_failed)
            }
        }
    }
}
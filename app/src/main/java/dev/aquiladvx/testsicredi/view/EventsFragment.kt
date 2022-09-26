package dev.aquiladvx.testsicredi.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import dev.aquiladvx.testsicredi.R
import dev.aquiladvx.testsicredi.common.BaseFragment
import dev.aquiladvx.testsicredi.common.Resource
import dev.aquiladvx.testsicredi.common.extension.observe
import dev.aquiladvx.testsicredi.databinding.FragmentEventsBinding
import dev.aquiladvx.testsicredi.model.entity.Event
import dev.aquiladvx.testsicredi.viewmodel.EventViewModel


class EventsFragment : BaseFragment() {

    private var _binding: FragmentEventsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: EventViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEventsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        setupObservers()
        viewModel.getEventsList()
    }

    private fun fetchEventsList(result: Resource<List<Event>>) {
        when (result) {
            is Resource.Loading -> {
                showLoading()
            }

            is Resource.Success -> {
                Toast.makeText(requireContext(), "success ${result.data?.size}", Toast.LENGTH_SHORT).show()
            }

            is Resource.DataError -> {
            }
        }
    }

    private fun setupObservers() {
        observe(viewModel.events, ::fetchEventsList)
    }

    private fun setupUI() {
        binding.btn.setOnClickListener {
            findNavController().navigate(R.id.action_HomeFragment_to_EventDetailFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
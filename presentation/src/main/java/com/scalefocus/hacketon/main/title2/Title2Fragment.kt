package com.scalefocus.hacketon.main.title2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.scalefocus.hacketon.databinding.FragmentTitle2Binding
import com.scalefocus.presentation.view.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Title2Fragment : BaseFragment<FragmentTitle2Binding>() {

    private val viewModel: Title2ViewModel by viewModels()

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentTitle2Binding =
        FragmentTitle2Binding.inflate(
            inflater,
            container,
            false
        )

    override fun onViewCreated(binding: FragmentTitle2Binding) {
        binding.viewModel = viewModel
    }
}
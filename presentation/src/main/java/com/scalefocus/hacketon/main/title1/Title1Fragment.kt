package com.scalefocus.hacketon.main.title1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.scalefocus.hacketon.databinding.FragmentTitle1Binding
import com.scalefocus.presentation.view.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Title1Fragment : BaseFragment<FragmentTitle1Binding>() {

    private val viewModel: Title1ViewModel by viewModels()

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentTitle1Binding =
        FragmentTitle1Binding.inflate(
            inflater,
            container,
            false
        )

    override fun onViewCreated(binding: FragmentTitle1Binding) {
        binding.viewModel = viewModel
    }
}
package com.scalefocus.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<BINDING : ViewBinding> : Fragment() {

    private lateinit var binding: BINDING

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflateBinding(inflater, container)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onViewCreated(binding)
    }

    abstract fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?): BINDING

    abstract fun onViewCreated(binding: BINDING)
}
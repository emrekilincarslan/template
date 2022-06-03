package com.scalefocus.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.scalefocus.presentation.baseutils.ErrorConsumer

abstract class BaseActivity<BINDING : ViewBinding> : AppCompatActivity(), ErrorConsumer {

    protected lateinit var binding: BINDING

    abstract fun inflateBinding(): BINDING

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflateBinding()
        setContentView(binding.root)
    }

    override fun displayErrorDialog(message: String) {

    }
}
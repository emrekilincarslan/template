package com.scalefocus.presentation.util

import android.text.TextWatcher
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.ViewTreeLifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.coroutines.MainScope

@BindingAdapter("visibility")
fun setViewVisibility(view: View, visible: Boolean) {
    if (visible) {
        view.visibility = View.VISIBLE
    } else {
        view.visibility = View.GONE
    }
}

@BindingAdapter("android:onClick")
fun setClickListener(
    view: View,
    onClickListener: View.OnClickListener
) {
    val scope = ViewTreeLifecycleOwner.get(view)?.lifecycleScope ?: MainScope()

    val clickWithDebounce: (view: View) -> Unit =
        debounce(scope = scope) {
            onClickListener.onClick(it)
        }

    view.setOnClickListener(clickWithDebounce)
}

@BindingAdapter(value = ["app:setAdapter"])
fun RecyclerView.bindRecyclerViewAdapter(adapter: RecyclerView.Adapter<*>) {
    this.run {
        this.setHasFixedSize(true)
        this.adapter = adapter
    }
}
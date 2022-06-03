package com.scalefocus.hacketon.main

import android.view.View
import androidx.databinding.Bindable
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.viewModelScope
//import com.scalefocus.base_service.RequestObserver
import com.scalefocus.hacketon.BR
import com.scalefocus.presentation.util.ObservableViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    //private val requestObserver: RequestObserver
) : ObservableViewModel(), LifecycleObserver {

    @get:Bindable
    var progressDialogVisibility: Int = View.GONE
        private set(value) {
            field = value
            notifyPropertyChanged(BR.progressDialogVisibility)
        }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private fun onStart() {
        viewModelScope.launch {
           /* requestObserver.observeRequests.collect {
                progressDialogVisibility = if (it) View.VISIBLE else View.GONE
            }*/
        }
    }
}
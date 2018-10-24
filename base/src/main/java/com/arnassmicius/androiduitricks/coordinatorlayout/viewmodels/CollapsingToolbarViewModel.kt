package com.arnassmicius.androiduitricks.coordinatorlayout.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arnassmicius.androiduitricks.coordinatorlayout.adapters.CollapsingToolbarSettingsAdapter
import com.arnassmicius.androiduitricks.coordinatorlayout.adapters.CollapsingToolbarSettingsAdapterDelegate

class CollapsingToolbarViewModel : ViewModel(), CollapsingToolbarSettingsAdapterDelegate {

    private val _adapter = MutableLiveData<CollapsingToolbarSettingsAdapter>()
    val adapter: LiveData<CollapsingToolbarSettingsAdapter>
        get() = _adapter

    private val _snapState = MutableLiveData<Boolean>()
    val snapState: LiveData<Boolean>
        get() = _snapState

    private val _actionBarState = MutableLiveData<Boolean>()
    val actionBarState: LiveData<Boolean>
        get() = _actionBarState

    init {
        _adapter.value = CollapsingToolbarSettingsAdapter(this)
        _snapState.value = _adapter.value?.isSnapEnabled()
        _actionBarState.value = _adapter.value?.isActionBarEnabled()
    }

    override fun onSnapClicked(state: Boolean) {
        _snapState.value = state
    }

    override fun onActionBarClicked(state: Boolean) {
        _actionBarState.value = state
    }
}

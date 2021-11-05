package com.ondev.daggerhilttest.ui.screens.home

import androidx.lifecycle.ViewModel
import com.ondev.randommodule.random.CRandom
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class RandomViewModel @Inject constructor(
    private val cRandom: CRandom
) : ViewModel() {

    private val _randomNum = MutableStateFlow(0)
    val randomNum = _randomNum

    fun onRandomChange() {
        _randomNum.value = cRandom.getRandomIn(0, 99999)
    }

    init {
        onRandomChange()
    }

}
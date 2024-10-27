package com.example.androidlopputyo.omaviewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidlopputyo.network.CatFact
import com.example.androidlopputyo.network.CatFactService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val catFactService = CatFactService.create()

    private val _catFact = MutableStateFlow("Click to get a cat fact!")
    val catFact: StateFlow<String> = _catFact

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading

    fun getNewCatFact() {
        viewModelScope.launch {
            _loading.value = true
            try {
                val facts = catFactService.getCatFacts()
                if (facts.isNotEmpty()) {
                    _catFact.value = facts.random().text
                } else {
                    _catFact.value = "No facts available"
                }
            } catch (e: Exception) {
                _catFact.value = "Failed to load fact: ${e.message}"
                Log.e("MainViewModel", "Error fetching cat fact", e)
            } finally {
                _loading.value = false
            }
        }
    }
}

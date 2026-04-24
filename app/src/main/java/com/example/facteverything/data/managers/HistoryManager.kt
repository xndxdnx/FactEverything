package com.example.facteverything.data.managers

import com.example.facteverything.model.Fact
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HistoryManager @Inject constructor() {
    private val _history = MutableStateFlow<List<Fact>>(emptyList())

    val history: StateFlow<List<Fact>> = _history.asStateFlow()

    fun addToHistory(item: Fact){
        _history.value = listOf<Fact>(item) + _history.value.take(9)
    }
}
package com.example.facteverything.data.managers

import com.example.facteverything.model.Fact
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FavoritesManager @Inject constructor() {


    private val _favorites = MutableStateFlow<Set<Int>>(emptySet())

    val favorites: StateFlow<Set<Int>> = _favorites.asStateFlow()

    fun addToFavorites(factId: Int){
        _favorites.value += factId
    }

    fun removeFromFavorites(factId: Int){
        _favorites.value -= factId
    }

    fun isFavorite(factId: Int): Boolean{
        return _favorites.value.contains(factId)
    }

}
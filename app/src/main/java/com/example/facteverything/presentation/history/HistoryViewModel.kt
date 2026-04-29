package com.example.facteverything.presentation.history

import androidx.lifecycle.ViewModel
import com.example.facteverything.data.managers.FavoritesManager
import com.example.facteverything.data.managers.HistoryManager
import com.example.facteverything.data.repository.FactRepository
import com.example.facteverything.model.Fact
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject


@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val favoriteManager: FavoritesManager,
    private val historyManager: HistoryManager,
): ViewModel() {

    val history: StateFlow<List<Fact>> = historyManager.history

    val favorites: StateFlow<Set<Int>> = favoriteManager.favorites


    fun toggleFavorites(factsId: Int){

        if(favoriteManager.isFavorite(factsId)){
            favoriteManager.removeFromFavorites(factsId)
        }else{
            favoriteManager.addToFavorites(factsId)
        }

    }


}
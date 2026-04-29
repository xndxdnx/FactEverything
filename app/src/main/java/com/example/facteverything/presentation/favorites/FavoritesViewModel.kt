package com.example.facteverything.presentation.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.facteverything.data.managers.FavoritesManager
import com.example.facteverything.data.repository.FactRepository
import com.example.facteverything.model.Fact
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val repository: FactRepository,
    private val favoriteManager: FavoritesManager
): ViewModel() {

    private var _favoritesFacts = MutableStateFlow<List<Fact>>(emptyList())

    val favoritesFacts: StateFlow<List<Fact>> = _favoritesFacts

    init {
        viewModelScope.launch {
            favoriteManager.favorites.collect{ ids ->
                _favoritesFacts.value = ids.mapNotNull { id ->           //Эта функция преобразования коллекции с определённым фильтром
                      repository.getFactById(id)                         // Применяет фильтр к каждому элементу исходной коллекции
                                                                        //  а если результата null то отбрасывает их, а итогом мы получаем List<*>
                }
            }
        }
    }

    fun toggleFavorites(factsId: Int){

        if(favoriteManager.isFavorite(factsId)){
            favoriteManager.removeFromFavorites(factsId)
        }else{
            favoriteManager.addToFavorites(factsId)
        }

    }

}
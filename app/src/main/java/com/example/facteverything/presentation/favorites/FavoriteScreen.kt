package com.example.facteverything.presentation.favorites

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.facteverything.presentation.components.FactCard

@Composable
fun FavoriteScreen(
    viewModel: FavoritesViewModel = hiltViewModel()
){
    val favorites by viewModel.favoritesFacts.collectAsState()

    if (favorites.isEmpty()){
        Text(
            text = "Избранное пусто",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier
                .padding(16.dp)
        )
    }else{
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            contentPadding = PaddingValues(vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(favorites){ fact ->
                FactCard(
                    fact = fact,
                    isFav = true,
                    onToggleFavorite = {
                        viewModel.toggleFavorites(fact.id)
                    }
                )
            }
        }
    }

}
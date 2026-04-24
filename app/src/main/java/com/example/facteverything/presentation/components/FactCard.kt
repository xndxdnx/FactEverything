package com.example.facteverything.presentation.components

import android.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.facteverything.model.Category
import com.example.facteverything.model.Fact
import com.example.facteverything.ui.theme.FactEverythingTheme


@Composable
fun FactCard(
    fact: Fact,
    isFav: Boolean,
    onToggleFavorite: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = fact.text,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier
                    .padding(bottom = 16.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically

            ) {
                Text(
                    text = "Категория: ${fact.category.displayName}",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
                )

                IconButton(
                    modifier = Modifier
                        .size(48.dp),
                    onClick = onToggleFavorite
                ) {
                    Icon(
                        imageVector =
                            if(isFav){
                            Icons.Filled.Favorite
                        }else{
                            Icons.Outlined.Favorite
                        },
                        contentDescription = "",
                        tint = if(isFav){
                            MaterialTheme.colorScheme.error
                        }else{
                            MaterialTheme.colorScheme.onSurfaceVariant
                        }
                    )


                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable

fun FactCardPreview(
){
    FactEverythingTheme() {
        FactCard(
          fact = Fact(id = 1,
              text = "Hello",
              category = Category.ANIMALS
              ),
            isFav = true,
            onToggleFavorite = {}
        )
    }

}

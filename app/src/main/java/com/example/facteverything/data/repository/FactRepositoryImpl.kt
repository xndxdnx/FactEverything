package com.example.facteverything.data.repository

import com.example.facteverything.model.Category
import com.example.facteverything.model.Fact
import javax.inject.Inject


class FactRepositoryImpl @Inject constructor() : FactRepository {

    private val factsByCategory = mapOf(
        Category.ANIMALS to listOf(
            Fact(
                id = 1,
                text = "Факт про животное 1",
                category = Category.ANIMALS
            ),
            Fact(
                id = 2,
                text = "Факт про животное 2",
                category = Category.ANIMALS
            )
        ),

        Category.HISTORY to listOf(
            Fact(
                id = 3,
                text = "Факт про историю 1",
                category = Category.HISTORY
            ),
            Fact(
                id = 4,
                text = "Факт про историю 2",
                category = Category.HISTORY
            )
        ),

//        Category.SCIENCE to listOf(
//            Fact(
//                id = 5,
//                text = "Факт про науку 1",
//                category = Category.SCIENCE
//            ),
//            Fact(
//                id = 6,
//                text = "Факт про науку 2",
//                category = Category.SCIENCE
//            )
//        )
    )

    override fun getRandomFact(category: Category): Fact {
        val facts = when (category) {
            Category.RANDOM -> factsByCategory.values.flatten()
            else -> factsByCategory[category] ?: emptyList()

        }
        return facts.random()
    }

    override fun getFactById(id: Int): Fact? {
        return factsByCategory.values.flatten().find { it.id == id }
    }


}
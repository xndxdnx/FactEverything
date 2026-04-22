package com.example.facteverything.data.repository

import com.example.facteverything.model.Category
import com.example.facteverything.model.Fact

interface FactRepository {
    fun getRandomFact(category: Category): Fact
    fun getFactById(id: Int): Fact?
}
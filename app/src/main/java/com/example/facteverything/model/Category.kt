package com.example.facteverything.model

import com.example.facteverything.R


enum class Category (
    val displayName:String,
    val iconResId: Int,

) {
    ANIMALS("Животные", R.drawable.pet_icon),
    HISTORY("История", R.drawable.book_icon),
    SCIENCE("Наука", R.drawable.science_icon),
    RANDOM("Случайное", R.drawable.question_icon)
}
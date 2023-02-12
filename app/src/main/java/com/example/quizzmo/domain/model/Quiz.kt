package com.example.quizzmo.domain.model

data class Quiz(
    val type:String,
    val name:String,
    val createdBy:String,
    val createdAt:String,
    val categoryName:String,
    val timeInSec:Int
)


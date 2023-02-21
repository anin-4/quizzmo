package com.example.quizzmo.domain.model

enum class QuizLevels{
    EASY,
    INTERMEDIATE,
    HARD
}

data class Quiz(
    val category:String,
    val type:String,
    val name:String,
    val createdBy:String,
    val createdAt:String,
    val timeInSec:Int,
    val level:QuizLevels
){
    fun secToMin():Int{
       return (timeInSec/60)
    }
}


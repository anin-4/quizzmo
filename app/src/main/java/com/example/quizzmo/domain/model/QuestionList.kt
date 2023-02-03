package com.example.quizzmo.domain.model

import com.example.quizzmo.domain.model.Question

data class QuestionList(
    val quizType:String,
    val categoryName:String,
    val questions:List<Question>
)

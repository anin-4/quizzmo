package com.example.quizzmo.domain.model


data class Question(
    val questionNumber:Int?=-1,
    val question:String?="",
    val options:List<String>?= listOf(),
    val answer:String?="",
    val createdBy:String?="",
    val createdAt:String?=""
)

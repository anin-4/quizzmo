package com.example.quizzmo.domain.model

import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.ktx.getField

data class Question(
    val questionNumber:Int?=-1,
    val question:String?="",
    val options:List<String>?= listOf(),
    val answer:String?="",
    val createdBy:String?="",
    val createdAt:String?=""
){
    companion object{
        fun DocumentSnapshot.toQuestion(): Question {
            val questionNumber = getLong("questionNumber")?.toInt()
            val question = getString("question")
            val options = getField<List<String>>("options")
            val answer = getString("answer")
            val createdBy = getString("createdBy")
            val createdAt = getString("createdAt")

            return Question(
                questionNumber,
                question,
                options,
                answer,
                createdAt,
                createdBy
            )

        }
    }
}

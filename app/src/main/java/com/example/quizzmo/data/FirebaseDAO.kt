package com.example.quizzmo.data

import com.example.quizzmo.domain.model.Question
import com.example.quizzmo.domain.model.QuestionList

interface FirebaseDAO {

    fun setUpQuiz(questionList: QuestionList)

    fun addOneQuestionAtATime(category: String, question: Question, quizType:String)

    suspend fun getQuestions(quizType: String,category: String,questionNumber:Int):List<Question>



}
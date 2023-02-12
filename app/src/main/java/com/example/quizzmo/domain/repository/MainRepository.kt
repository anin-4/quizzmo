package com.example.quizzmo.domain.repository

import com.example.quizzmo.domain.model.Question
import com.example.quizzmo.domain.model.QuestionList
import com.example.quizzmo.domain.model.Quiz
import kotlinx.coroutines.flow.Flow

interface MainRepository {

        suspend fun addDummyQuiz(questionList: QuestionList)

        suspend fun getListOfDummyQuiz(): Flow<List<Quiz?>?>

        suspend fun getQuestionsForDummyQuiz(category:String):List<Question?>
}
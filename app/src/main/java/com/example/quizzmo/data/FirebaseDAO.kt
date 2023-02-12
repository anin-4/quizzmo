package com.example.quizzmo.data


import com.example.quizzmo.domain.model.Question
import com.example.quizzmo.domain.model.QuestionList
import com.example.quizzmo.domain.model.Quiz
import kotlinx.coroutines.flow.Flow

interface FirebaseDAO {

    suspend fun setUpQuiz(questionList: QuestionList)

    suspend fun getQuestionsForDummyQuiz(category: String):List<Question?>

    suspend fun addDummyQuiz(quiz: Quiz)

    suspend fun getListOfDummyQuizzes():Flow<List<Quiz?>?>




}
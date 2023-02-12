package com.example.quizzmo.domain.repository

import com.example.quizzmo.data.FirebaseDAO
import com.example.quizzmo.domain.model.Question
import com.example.quizzmo.domain.model.QuestionList
import com.example.quizzmo.domain.model.Quiz
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val firebaseDAO: FirebaseDAO
):MainRepository {

    override suspend fun addDummyQuiz(questionList: QuestionList) {
       firebaseDAO.setUpQuiz(questionList)
    }

    override suspend fun getListOfDummyQuiz(): Flow<List<Quiz?>?> {
        return firebaseDAO.getListOfDummyQuizzes()
    }

    override suspend fun getQuestionsForDummyQuiz(category: String): List<Question?> {
        return firebaseDAO.getQuestionsForDummyQuiz(category)
    }


}
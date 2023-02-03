package com.example.quizzmo.data


import android.util.Log
import com.example.quizzmo.domain.model.Question
import com.example.quizzmo.domain.model.Question.Companion.toQuestion
import com.example.quizzmo.domain.model.QuestionList
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

class FireBaseDAOImpl private constructor():FirebaseDAO {

    private val db = Firebase.firestore

    companion object{
        const val TAG = "FireBaseDAOImpl"

        var INSTANCE:FirebaseDAO? =null

        fun getInstance():FirebaseDAO{
            if(INSTANCE==null){
                INSTANCE = FireBaseDAOImpl()
                return INSTANCE as FirebaseDAO
            }
            return INSTANCE as FirebaseDAO
        }
    }

    override fun setUpQuiz(questionList: QuestionList) {
        val category = questionList.categoryName
        val quizType = questionList.quizType
            for (question in questionList.questions) {
              addOneQuestionAtATime(category,question,quizType)
            }
    }

    override fun addOneQuestionAtATime(category: String, question: Question, quizType:String) {
        db.collection(quizType)
            .document(category)
            .collection("questions")
            .document()
            .set(question)
            .addOnSuccessListener {
                Log.d(TAG, "setUpQuiz: quiz set up properly")
            }
            .addOnFailureListener {
                Log.d(TAG, "setUpQuiz: An error occured while setting up quiz")
            }
    }

    override suspend fun getQuestions(quizType: String, category: String, questionNumber: Int):List<Question> {
        return try {
            val querySnapshot = db.collection(quizType)
                .document(category)
                .collection("questions")
                .get()
                .await()

            val questions = querySnapshot.documents.map {
                it.toQuestion()
            }
             questions
        }catch (e:Exception){
            Log.d(TAG, "getQuestion: something went wrong")
            emptyList()
        }
    }


}
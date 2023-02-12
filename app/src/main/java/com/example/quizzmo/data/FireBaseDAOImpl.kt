package com.example.quizzmo.data


import android.util.Log
import com.example.quizzmo.domain.model.Question
import com.example.quizzmo.domain.model.QuestionList
import com.example.quizzmo.domain.model.Quiz
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
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

    //used to set up both type of quizzes depending upon the category - quiz or dummyQuiz
    override suspend fun setUpQuiz(questionList: QuestionList) {
        val category = questionList.categoryName
        val quizType = questionList.quizType
            for (question in questionList.questions) {
              addOneQuestionAtATime(category,question,quizType)
            }
    }

    private suspend fun addOneQuestionAtATime(category: String, question: Question, quizType:String) {
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

    //used to get questions for dummy quizzes only
    override suspend fun getQuestionsForDummyQuiz(category: String):List<Question?> {
        return try {
            val querySnapshot = db.collection("dummyQuiz")
                .document(category)
                .collection("questions")
                .get()
                .await()

            val questions = querySnapshot.documents.map {
                it.toObject(Question::class.java)
            }
             questions
        }catch (e:Exception){
            Log.d(TAG, "getQuestion: something went wrong ${e.localizedMessage}")
            emptyList()
        }
    }

    //used to set up list of dummyQuiz
    override suspend fun addDummyQuiz(quiz: Quiz){
        db.collection("DummyQuizList").add(quiz)
    }

    //get the list of dummy quizzes
    override suspend fun getListOfDummyQuizzes():Flow<List<Quiz?>?> {
        return callbackFlow {
            val listener = db.collection("DummyQuizList")
                .addSnapshotListener { value, error ->
                    if(error!=null){
                        Log.d(TAG, "getListOfQuizzes: something went wrong")
                        return@addSnapshotListener
                    }
                   val dummyQuizzes = value?.documents?.map {
                       it.toObject(Quiz::class.java)
                   }

                        trySend(dummyQuizzes).isSuccess
                    }
                    awaitClose {
                        listener.remove()
                    }

                }

        }
    }

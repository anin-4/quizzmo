package com.example.quizzmo.ui.playquiz

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizzmo.domain.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@HiltViewModel
class QuizScreenViewModel(
    private val mainRepository: MainRepository
):ViewModel() {

    var state:MutableState<QuizScreenState> = mutableStateOf(QuizScreenState())
    private set

    init {
        getQuestionsForDummyQuiz(category = "History")
    }


    fun onEvent(quizScreenEvents: QuizScreenEvents){
        when(quizScreenEvents){
            is QuizScreenEvents.OnQuestionSelected -> {
                state.value.copy(
                    selectedOptionIndex = quizScreenEvents.questionNumber
                )
            }

            is QuizScreenEvents.OnNavigationButtonClicked -> {
                val currentQuestionNumber = state.value.selectedQuestionNumber
                if(quizScreenEvents.next){
                    state.value.copy(
                        selectedQuestionNumber = if(currentQuestionNumber<=9) currentQuestionNumber+1 else currentQuestionNumber
                    )
                }else{
                    state.value.copy(
                        selectedQuestionNumber = if(currentQuestionNumber>=1) currentQuestionNumber-1 else currentQuestionNumber
                    )
                }
            }

            is QuizScreenEvents.OnOptionSelected ->{
                val currentQuestion = state.value.selectedQuestionNumber
                val optionSelected = quizScreenEvents.optionIndex
                state.value.copy(
                    selectedOptionIndex = optionSelected
                )
                state.value.mapQuestionNumberToSelectedOption(optionSelected,currentQuestion)
            }

            is QuizScreenEvents.OnFinishButtonSelected -> {
                val questions = state.value.questions
                val ansMarkedByUser = state.value.questionAndOptionHolder
                var ansCounter =0
                questions.forEach {
                    it?.let { question ->
                        if(question.answer == ansMarkedByUser.get(question.questionNumber)
                                ?.let { it1 -> question.options?.get(it1) }){
                            ansCounter++
                        }
                    }
                }

                state.value.copy(finalScore = ansCounter)
            }
        }
    }


    private fun getQuestionsForDummyQuiz(category:String){
        viewModelScope.launch(Dispatchers.IO) {
           val response = mainRepository.getQuestionsForDummyQuiz(category)

            state.value.copy(
                questions = response
            )

        }
    }

}
package com.example.quizzmo.ui.playquiz


sealed class QuizScreenEvents{
    data class OnNavigationButtonClicked(val next:Boolean):QuizScreenEvents()
    data class OnOptionSelected(val optionIndex:Int):QuizScreenEvents()
    data class OnQuestionSelected(val questionNumber: Int):QuizScreenEvents()
    object OnFinishButtonSelected : QuizScreenEvents()
}

package com.example.quizzmo.ui.playquiz

import com.example.quizzmo.domain.model.Question

data class QuizScreenState(
    var selectedOptionIndex:Int=-1,
    var isLoading:Boolean=false,
    var questions:List<Question?> = emptyList(),
    var selectedQuestionNumber:Int =1,
    var questionAndOptionHolder:HashMap<Int,Int> = HashMap(), //mapping question number to selected options to compare at the end
    var finalScore:Int =0
){
    public fun mapQuestionNumberToSelectedOption(index:Int,questionNumber:Int){
        questionAndOptionHolder[questionNumber] = index
    }
}

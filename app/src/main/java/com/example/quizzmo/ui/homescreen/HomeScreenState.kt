package com.example.quizzmo.ui.homescreen

import com.example.quizzmo.domain.model.Quiz

data class HomeScreenState(
    val availableQuizzes:List<Quiz?> = emptyList(),
    val isLoading:Boolean = false,
    val selectedIndex:Int =0
)

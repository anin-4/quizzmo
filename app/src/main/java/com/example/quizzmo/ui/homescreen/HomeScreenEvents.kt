package com.example.quizzmo.ui.homescreen

import com.example.quizzmo.domain.model.Quiz

sealed class HomeScreenEvents{
    data class OnStartButtonClicked(val quiz:Quiz):HomeScreenEvents()
    data class OnItemSelected(val index:Int):HomeScreenEvents()
}

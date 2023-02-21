package com.example.quizzmo.ui.homescreen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizzmo.domain.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val mainRepository: MainRepository
):ViewModel() {

    var state:MutableState<HomeScreenState> = mutableStateOf(HomeScreenState())
    private set


    init {
        getListOfDummyQuizzes()
    }


    fun onEvent(homeScreenEvents: HomeScreenEvents){
        when(homeScreenEvents){
            is HomeScreenEvents.OnStartButtonClicked -> {
                //todo
            }

            is HomeScreenEvents.OnItemSelected -> {
                state.value = state.value.copy(selectedIndex = homeScreenEvents.index)
            }
        }
    }


    private fun getListOfDummyQuizzes() = viewModelScope.launch(Dispatchers.IO){
        mainRepository.getListOfDummyQuiz().onEach { quizzes ->
                quizzes?.let {
                    state.value = state.value.copy(availableQuizzes = it)
                }
        }

    }

}
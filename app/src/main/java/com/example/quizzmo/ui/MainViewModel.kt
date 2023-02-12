package com.example.quizzmo.ui


import androidx.lifecycle.ViewModel
import com.example.quizzmo.domain.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
): ViewModel() {


}
package com.example.quizzmo.di

import com.example.quizzmo.data.FireBaseDAOImpl
import com.example.quizzmo.data.FirebaseDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataModule {

        @Singleton
        @Provides
        fun provideFireBaseDAO():FirebaseDAO = FireBaseDAOImpl.getInstance()
}
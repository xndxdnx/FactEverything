package com.example.facteverything.DI

import com.example.facteverything.data.repository.FactRepository
import com.example.facteverything.data.repository.FactRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton

    fun providesFactRepository(): FactRepository{
        return FactRepositoryImpl()
    }

}
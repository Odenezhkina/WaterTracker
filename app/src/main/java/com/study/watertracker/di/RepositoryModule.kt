package com.study.watertracker.di

import com.study.watertracker.data.repository.WaterIntakeRepositoryImpl
import com.study.watertracker.domain.repository.WaterIntakeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindsWaterRepository(waterIntakeRepositoryImpl: WaterIntakeRepositoryImpl): WaterIntakeRepository
}

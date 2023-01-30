package com.study.watertracker.di

import com.study.watertracker.domain.repository.WaterIntakeRepository
import com.study.watertracker.domain.usecase.GetWaterIntakeByDay
import com.study.watertracker.domain.usecase.UpdateWaterIntake
import com.study.watertracker.domain.usecase.WaterUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
interface UseCasesModule {

    @Provides
    @Singleton
    fun providesWaterUseCases(waterIntakeRepository: WaterIntakeRepository) =
        WaterUseCases(
            getWaterIntakeByDay = GetWaterIntakeByDay(waterIntakeRepository),
            updateWaterIntake = UpdateWaterIntake(waterIntakeRepository)
        )
}

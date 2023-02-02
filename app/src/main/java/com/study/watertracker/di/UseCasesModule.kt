package com.study.watertracker.di

import com.study.watertracker.domain.repository.WaterIntakeRepository
import com.study.watertracker.domain.usecase.water.GetWaterIntakeByDay
import com.study.watertracker.domain.usecase.water.UpdateWaterIntake
import com.study.watertracker.domain.usecase.water.WaterUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCasesModule {

    @Provides
    @Singleton
    fun providesWaterUseCases(waterIntakeRepository: WaterIntakeRepository) =
        WaterUseCases(
            getWaterIntakeByDay = GetWaterIntakeByDay(waterIntakeRepository),
            updateWaterIntake = UpdateWaterIntake(waterIntakeRepository)
        )
}

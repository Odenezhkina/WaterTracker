package com.study.watertracker.domain.repository

import com.study.watertracker.domain.model.WaterMetrics
import kotlinx.coroutines.flow.Flow

interface UserSettingsRepository {

    fun getDailyWaterIntake(): Flow<Float>

    suspend fun saveDailyWaterIntake(value: Float)

    fun getWaterMetrics(): Flow<WaterMetrics>

    suspend fun saveWaterMetrics(waterMetrics: WaterMetrics)

    fun getWaterIntakePerGlass(): Flow<Float>

    suspend fun saveWaterIntakePerGlass(value: Float)
}

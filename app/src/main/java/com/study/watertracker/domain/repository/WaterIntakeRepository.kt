package com.study.watertracker.domain.repository

import com.study.watertracker.domain.model.DayWaterIntake
import kotlinx.coroutines.flow.Flow
import java.util.*

interface WaterIntakeRepository {
    fun getAll(): Flow<List<DayWaterIntake>>

    fun getByDay(calendar: Calendar): Flow<DayWaterIntake?>

    suspend fun updateByDay(waterIntake: DayWaterIntake)

    suspend fun add(waterIntake: DayWaterIntake): Long

    suspend fun getCountOfAll(): Int

    fun getAllByMonth(calendar: Calendar): Flow<List<DayWaterIntake>>
}

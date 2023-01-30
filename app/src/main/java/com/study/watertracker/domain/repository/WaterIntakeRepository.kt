package com.study.watertracker.domain.repository

import com.study.watertracker.domain.model.DayWaterIntake
import kotlinx.coroutines.flow.Flow
import java.util.*

interface WaterIntakeRepository {
    fun getAll(): Flow<List<DayWaterIntake>>

    suspend fun getByDay(calendar: Calendar): DayWaterIntake?

    suspend fun add(waterIntake: DayWaterIntake): Long

    suspend fun getCountOfAll(): Int

    fun getAllByMonth(calendar: Calendar): Flow<List<DayWaterIntake>>
}

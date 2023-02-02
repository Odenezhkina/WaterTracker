package com.study.watertracker.domain.repository

import com.study.watertracker.domain.model.WaterIntake
import kotlinx.coroutines.flow.Flow
import java.util.*

interface WaterIntakeRepository {
    fun getAll(): Flow<List<WaterIntake>>

    fun getByDay(calendar: Calendar): Flow<WaterIntake?>

    suspend fun updateByDay(waterIntake: WaterIntake)

    suspend fun add(waterIntake: WaterIntake): Long

    suspend fun getCountOfAll(): Int

    fun getAllByMonth(calendar: Calendar): Flow<List<WaterIntake>>
}

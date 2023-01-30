package com.study.watertracker.data.repository

import com.study.watertracker.data.dao.WaterIntakeDao
import com.study.watertracker.data.mappers.toWaterIntake
import com.study.watertracker.data.mappers.toWaterIntakeEntity
import com.study.watertracker.domain.model.DayWaterIntake
import com.study.watertracker.domain.repository.WaterIntakeRepository
import com.study.watertracker.domain.util.setEndtOfTheDay
import com.study.watertracker.domain.util.setStartOfTheDay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.*

class WaterIntakeRepositoryImpl(private val dao: WaterIntakeDao) : WaterIntakeRepository {
    override fun getAll(): Flow<List<DayWaterIntake>> =
        dao.getAll().map { it.map { entity -> entity.toWaterIntake() } }

    override fun getAllByMonth(calendar: Calendar): Flow<List<DayWaterIntake>> {
        TODO("Not yet implemented")
    }

    override suspend fun getByDay(calendar: Calendar): DayWaterIntake? {
        return dao.getByDay(
            dayStart = calendar.setStartOfTheDay().timeInMillis,
            dayEnd = calendar.setEndtOfTheDay().timeInMillis
        )?.toWaterIntake()
    }

    override suspend fun add(waterIntake: DayWaterIntake): Long =
        dao.insert(waterIntake.toWaterIntakeEntity())

    override suspend fun getCountOfAll(): Int =
        dao.countAll()

}
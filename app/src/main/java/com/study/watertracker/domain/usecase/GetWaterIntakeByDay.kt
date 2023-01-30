package com.study.watertracker.domain.usecase

import com.study.watertracker.domain.model.DayWaterIntake
import com.study.watertracker.domain.repository.WaterIntakeRepository
import kotlinx.coroutines.flow.Flow
import java.util.*
import javax.inject.Inject

class GetWaterIntakeByDay @Inject constructor(private val waterIntakeRepository: WaterIntakeRepository) {

    operator fun invoke(): Flow<DayWaterIntake?> {
        val currentDay = Calendar.getInstance()
        return waterIntakeRepository.getByDay(currentDay)
    }
}

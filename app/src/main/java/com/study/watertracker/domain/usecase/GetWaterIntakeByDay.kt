package com.study.watertracker.domain.usecase

import com.study.watertracker.domain.model.WaterIntake
import com.study.watertracker.domain.repository.WaterIntakeRepository
import kotlinx.coroutines.flow.Flow
import java.util.*
import javax.inject.Inject

class GetWaterIntakeByDay @Inject constructor(private val waterIntakeRepository: WaterIntakeRepository) {

    operator fun invoke(): Flow<WaterIntake?> {
        val currentDay = Calendar.getInstance()
        return waterIntakeRepository.getByDay(currentDay)
    }
}

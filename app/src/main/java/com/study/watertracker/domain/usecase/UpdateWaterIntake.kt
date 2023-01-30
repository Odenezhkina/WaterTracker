package com.study.watertracker.domain.usecase

import com.study.watertracker.domain.model.DayWaterIntake
import com.study.watertracker.domain.repository.WaterIntakeRepository
import javax.inject.Inject

class UpdateWaterIntake @Inject constructor(private val waterIntakeRepository: WaterIntakeRepository) {

    suspend operator fun invoke(waterIntake: DayWaterIntake) {
        waterIntakeRepository.updateByDay(waterIntake)
    }
}

package com.study.watertracker.domain.usecase.water

import com.study.watertracker.domain.model.WaterIntake
import com.study.watertracker.domain.repository.WaterIntakeRepository
import javax.inject.Inject

class UpdateWaterIntake @Inject constructor(private val waterIntakeRepository: WaterIntakeRepository) {

    suspend operator fun invoke(waterIntake: WaterIntake) {
        waterIntakeRepository.updateByDay(waterIntake)
    }
}

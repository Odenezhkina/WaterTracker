package com.study.watertracker.domain.usecase

data class WaterUseCases(
    val getWaterIntakeByDay: GetWaterIntakeByDay,
    val updateWaterIntake: UpdateWaterIntake
)

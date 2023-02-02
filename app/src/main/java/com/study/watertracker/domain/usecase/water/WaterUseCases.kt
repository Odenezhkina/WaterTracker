package com.study.watertracker.domain.usecase.water

data class WaterUseCases(
    val getWaterIntakeByDay: GetWaterIntakeByDay,
    val updateWaterIntake: UpdateWaterIntake
)

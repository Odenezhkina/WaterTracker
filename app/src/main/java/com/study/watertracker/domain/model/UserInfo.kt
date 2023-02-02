package com.study.watertracker.domain.model

data class UserInfo(
    val gender: Boolean = DEFAULT_GENDER,
    val activityLevel: ActivityLevel = DEFAULT_ACTIVITY_LEVEL,
    val weight: Int = DEFAULT_WEIGHT
) {
    companion object {
        const val DEFAULT_GENDER = true
        val DEFAULT_ACTIVITY_LEVEL = ActivityLevel.AVERAGE
        const val DEFAULT_WEIGHT = 55
    }
}

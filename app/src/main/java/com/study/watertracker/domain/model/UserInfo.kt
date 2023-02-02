package com.study.watertracker.domain.model

import androidx.annotation.StringRes
import com.study.watertracker.R

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

enum class ActivityLevel(@StringRes val titleId: Int) {
    LOW(R.string.activity_level_low), AVERAGE(R.string.activity_level_average), HIGH(R.string.activity_level_high)
}

enum class Gender(@StringRes val titleId: Int) {
    FEMALE(R.string.gender_female), MALE(R.string.gender_male)
}

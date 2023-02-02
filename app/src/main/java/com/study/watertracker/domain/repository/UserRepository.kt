package com.study.watertracker.domain.repository

import com.study.watertracker.domain.model.ActivityLevel

interface UserRepository {

    suspend fun getGender(): Boolean
    suspend fun saveGender(value: Boolean)

    suspend fun getWeight(): Int
    suspend fun saveWeight(value: Int)

    suspend fun getActivityLevel(): ActivityLevel
    suspend fun saveActivityLevel(activityLevel: ActivityLevel)

}

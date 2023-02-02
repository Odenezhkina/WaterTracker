package com.study.watertracker.domain.usecase.user.info

import com.study.watertracker.domain.model.ActivityLevel
import com.study.watertracker.domain.repository.UserRepository

class UpdateActivityLevel(private val userRepository: UserRepository) {

    suspend operator fun invoke(activityLevel: ActivityLevel) {
        return userRepository.saveActivityLevel(activityLevel)
    }
}

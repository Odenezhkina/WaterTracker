package com.study.watertracker.domain.usecase.user.info

import com.study.watertracker.domain.model.UserInfo
import com.study.watertracker.domain.repository.UserRepository

class GetUserInfo(private val userRepository: UserRepository){

    suspend operator fun invoke(): UserInfo{
        return UserInfo(
            gender = userRepository.getGender(),
            activityLevel = userRepository.getActivityLevel(),
            weight = userRepository.getWeight()
        )
    }
}

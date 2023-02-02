package com.study.watertracker.domain.usecase.user.info

import com.study.watertracker.domain.repository.UserRepository

class UpdateGender(private val userRepository: UserRepository) {

    suspend operator fun invoke(gender: Boolean) {
        return userRepository.saveGender(gender)
    }
}

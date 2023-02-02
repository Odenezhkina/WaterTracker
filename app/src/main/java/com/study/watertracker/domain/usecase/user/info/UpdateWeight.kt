package com.study.watertracker.domain.usecase.user.info

import com.study.watertracker.domain.repository.UserRepository

class UpdateWeight(private val userRepository: UserRepository) {

    suspend operator fun invoke(weight: Int) {
        return userRepository.saveWeight(weight)
    }
}

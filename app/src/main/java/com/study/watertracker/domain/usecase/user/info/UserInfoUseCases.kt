package com.study.watertracker.domain.usecase.user.info

class UserInfoUseCases(
    val getUserInfo: GetUserInfo,
    val updateActivityLevel: UpdateActivityLevel,
    val updateGender: UpdateGender,
    val updateWeight: UpdateWeight
)

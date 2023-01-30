package com.study.watertracker.presentation.home

sealed interface HomeEvent {
    object TryAgain : HomeEvent
    object AddGlassOfWater : HomeEvent
}

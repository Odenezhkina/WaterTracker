package com.study.watertracker.util

sealed class UiState<T>(val data: T? = null, val error: Throwable? = null) {
    class Loading<T> : UiState<T>()
    class Success<T>(data: T) : UiState<T>(data)
    class Error<T>(error: Throwable) : UiState<T>(error = error)
}

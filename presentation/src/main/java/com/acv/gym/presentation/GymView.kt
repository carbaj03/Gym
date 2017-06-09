package com.acv.gym.presentation

interface GymView

interface ViewError {
    fun showNetworkError()
    fun showServerError()
}

interface ViewShow<in T> {
    fun show(sessionSets: List<T>)
}

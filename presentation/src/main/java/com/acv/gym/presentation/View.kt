package com.acv.gym.presentation

interface View

interface ViewError {
    fun showNetworkError()
    fun showServerError()
}

interface ViewShow<in T> {
    fun show(data: List<T>)
}

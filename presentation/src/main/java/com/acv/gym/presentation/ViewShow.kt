package com.acv.gym.presentation

interface ViewShow<in T> {
    fun show(data: List<T>)
}

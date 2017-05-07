package com.acv.gym.data.local

interface Cache {
    fun <T> get(name: String, default: T): T
    fun <T> put(name: String, value: T)
}

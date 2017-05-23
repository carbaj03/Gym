package com.acv.gym.data.db.cache

interface Cache {
    fun <T> get(name: String, default: T): T
    fun <T> put(name: String, value: T)
}

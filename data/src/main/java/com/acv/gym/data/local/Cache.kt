package com.acv.gym.data.local

import android.content.Context

interface Cache {
    fun <T>get(name: String, default: T) : T
    fun <T>put(name: String, value: T)
}

package com.acv.gym.domain.commons.logger

interface Logger {

    fun tag(tag: String)

    fun d(message: String, vararg objects: Any)
    fun d(t: Throwable)
    fun d(t: Throwable, message: String, vararg objects: Any)

    fun i(message: String, vararg objects: Any)
    fun i(t: Throwable)
    fun i(t: Throwable, message: String, vararg objects: Any)

    fun e(message: String, vararg objects: Any)
    fun e(t: Throwable)
    fun e(t: Throwable, message: String, vararg objects: Any)
}

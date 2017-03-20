package com.acv.gym.presentation

interface GymViewInjector {
    fun <V> injectView(view: V): V
    fun <V> nullObjectPatternView(view: V): V
}

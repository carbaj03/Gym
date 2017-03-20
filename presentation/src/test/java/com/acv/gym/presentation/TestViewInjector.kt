package com.acv.gym.presentation

class TestViewInjector : GymViewInjector {
    override fun <V> injectView(view: V): V  = view

    override fun <V> nullObjectPatternView(view: V): V = view
}

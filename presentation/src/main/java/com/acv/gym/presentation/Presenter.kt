package com.acv.gym.presentation

abstract class Presenter<V>(val viewInjector: GymViewInjector) {
    var view: V? = null
        private set

    fun attachView(view: V) {
        this.view = viewInjector.injectView(view)
        onViewAttached()
    }

    fun detachView() {
        this.view = viewInjector.nullObjectPatternView(view)
    }

    abstract fun onViewAttached()
}

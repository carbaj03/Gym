package com.acv.gym.presentation


abstract class Presenter<out T : GymView>(val view: T) {

//    lateinit var view: T

//    fun attachView(view: T){
//        this.view = view
//    }


    open fun initialize() {
//        logger.d("BasePresenter", "-> initialize (This method can be override but is no needed)")
    }


    open fun update() {
//        logger.d("BasePresenter", "-> update (This method can be override but is no needed)")
    }


    open fun pause() {
//        logger.d("BasePresenter", "-> pause (This method can be override but is no needed)")
    }

    open fun destroy() {
//        logger.d("BasePresenter", "-> destroy (This method can be override but is no needed)")
    }

}

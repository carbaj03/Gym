package com.acv.gym.presentation


abstract class Presenter<out T : View>(val view : T) {

//    lateinit var view: T

//    fun attachView(view: T){
//        this.view = view
//    }

    /**
     * Method called in the presenter lifecycle. Invoked when the component containing the presenter is initialized.
     */
    open fun initialize() {
//        logger.d("BasePresenter", "-> initialize (This method can be override but is no needed)")
    }

    /**
     * Method called in the presenter lifecycle. Invoked when the component containing the presenter is resumed.
     */
    open fun update() {
//        logger.d("BasePresenter", "-> update (This method can be override but is no needed)")
    }

    /**
     * Method called in the presenter lifecycle. Invoked when the component containing the presenter is paused.
     */
    open fun pause() {
//        logger.d("BasePresenter", "-> pause (This method can be override but is no needed)")
    }

    open fun destroy() {
//        logger.d("BasePresenter", "-> destroy (This method can be override but is no needed)")
    }

}

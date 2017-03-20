package com.acv.gym.ui.customview.spinner

interface SpinnerLoading {
    fun show()
    fun show(listener: SpinnerLoadingListener)

    fun dismiss()
    fun dismiss(listener: SpinnerLoadingListener)

}

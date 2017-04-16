package com.acv.gym.commons.extension

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import com.acv.gym.ui.BaseActivity
import com.acv.gym.ui.commons.goToActivity
import com.acv.gym.ui.commons.setFadeInOutAnimation

fun ViewGroup.inflate(res: Int) = LayoutInflater.from(context).inflate(res, this, false)

inline fun <reified T : Activity> BaseActivity.nav(){
    goToActivity<T>()
    setFadeInOutAnimation()
}
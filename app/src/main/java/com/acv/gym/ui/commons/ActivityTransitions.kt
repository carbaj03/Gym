package com.acv.gym.ui.commons

import android.content.Context

import com.acv.gym.R
import com.acv.gym.ui.BaseActivity


object ActivityTransitions {
    fun setFadeInOutAnimation(context: Context)
            = (context as BaseActivity).overridePendingTransition(R.anim.anim_fade_in, R.anim.anim_fade_out)

    fun setSlideUpAnimation(context: Context)
            = (context as BaseActivity).overridePendingTransition(R.anim.anim_slide_up, R.anim.anim_no_change)

    fun setSlideRightAnimation(context: Context)
            = (context as BaseActivity).overridePendingTransition(R.anim.anim_slide_enter_from_right, R.anim.anim_no_change)

    fun setSlideExitToRightAnimation(context: Context)
            = (context as BaseActivity).overridePendingTransition(R.anim.anim_no_change, R.anim.anim_slide_exit_to_right)
}

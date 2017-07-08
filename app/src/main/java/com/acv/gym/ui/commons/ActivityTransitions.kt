package com.acv.gym.ui.commons

import android.app.Activity
import com.acv.gym.R

fun Activity.setFadeInOutAnimation()
        = overridePendingTransition(R.anim.fade_in, R.anim.fade_out)

fun Activity.setSlideUpAnimation()
        = overridePendingTransition(R.anim.slide_in_up, R.anim.no_change)

fun Activity.setSlideRightAnimation()
        = overridePendingTransition(R.anim.slide_in_right, R.anim.no_change)

fun Activity.setSlideExitToRightAnimation()
        = overridePendingTransition(R.anim.no_change, R.anim.slide_out_right)
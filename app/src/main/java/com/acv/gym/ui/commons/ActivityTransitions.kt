package com.acv.gym.ui.commons

import android.app.Activity
import android.content.Intent
import com.acv.gym.R
import katz.Option

fun Activity.setFadeInOutAnimation()
        = overridePendingTransition(R.anim.fade_in, R.anim.fade_out)

fun Activity.setSlideUpAnimation()
        = overridePendingTransition(R.anim.slide_up, R.anim.anim_no_change)

fun Activity.setSlideRightAnimation()
        = overridePendingTransition(R.anim.slide_enter_from_right, R.anim.anim_no_change)

fun Activity.setSlideExitToRightAnimation()
        = overridePendingTransition(R.anim.anim_no_change, R.anim.slide_exit_to_right)
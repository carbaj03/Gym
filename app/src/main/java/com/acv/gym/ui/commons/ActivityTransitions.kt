package com.acv.gym.ui.commons

import android.app.Activity
import android.content.Intent
import com.acv.gym.R
import katz.Option

fun Activity.setFadeInOutAnimation()
        = overridePendingTransition(R.anim.anim_fade_in, R.anim.anim_fade_out)

fun Activity.setSlideUpAnimation()
        = overridePendingTransition(R.anim.anim_slide_up, R.anim.anim_no_change)

fun Activity.setSlideRightAnimation()
        = overridePendingTransition(R.anim.anim_slide_enter_from_right, R.anim.anim_no_change)

fun Activity.setSlideExitToRightAnimation()
        = overridePendingTransition(R.anim.anim_no_change, R.anim.anim_slide_exit_to_right)

inline fun <reified T : Activity> Activity.goToActivity(id: Option<String>) {
    val intent = Intent(this, T::class.java)
    id.map { intent.putExtra("ID", it) }
    startActivity(intent)
}
package com.acv.gym.ui.navigation

import android.content.Context

import com.acv.gym.ui.commons.ActivityTransitions

class Navigator {
    fun navigateToLoginView(context: Context) {
        //        context.startActivity(LoginActivity.getCallingIntent(context));
        ActivityTransitions.setFadeInOutAnimation(context)
    }
}

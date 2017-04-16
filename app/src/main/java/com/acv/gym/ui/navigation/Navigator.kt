package com.acv.gym.ui.navigation

import android.app.Activity
import com.acv.gym.module.routine.RoutineActivity
import com.acv.gym.module.session.SessionActivity
import com.acv.gym.ui.BaseActivity
import com.acv.gym.ui.commons.goToActivity
import com.acv.gym.ui.commons.setFadeInOutAnimation

class Navigator {
    fun navigateToRoutines(context: BaseActivity) {
        context.goToActivity<RoutineActivity>()
        context.setFadeInOutAnimation()
    }

    fun navigateToSession(context: BaseActivity) {
        context.goToActivity<SessionActivity>()
        context.setFadeInOutAnimation()
    }

    fun navigateToMuscleGroup(context: BaseActivity) {
        context.goToActivity<RoutineActivity>()
        context.setFadeInOutAnimation()
    }

}

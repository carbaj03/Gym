package com.acv.gym.ui.navigation

import com.acv.gym.module.routines.RoutinesActivity
import com.acv.gym.ui.BaseActivity
import com.acv.gym.ui.commons.goToActivity
import com.acv.gym.ui.commons.setFadeInOutAnimation

class Navigator {
    fun navigateToRoutines(context: BaseActivity) {
        context.goToActivity<RoutinesActivity>()
        context.setFadeInOutAnimation()
    }

//    fun navigateToTemplate(context: BaseActivity, id: String) {
//        context.goToActivity<TemplateActivity>()
//    }
}

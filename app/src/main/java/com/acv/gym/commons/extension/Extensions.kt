package com.acv.gym.commons.extension

import android.app.Activity
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.ViewGroup
import com.acv.gym.GymApplication
import com.acv.gym.R
import com.acv.gym.di.module.*
import com.acv.gym.module.exercise.ExerciseActivity
import com.acv.gym.module.exercise.type.ExerciseTypeActivity
import com.acv.gym.module.muscle.group.MuscleGroupActivity
import com.acv.gym.module.rep.RepActivity
import com.acv.gym.module.routine.RoutineActivity
import com.acv.gym.module.session.SessionActivity
import com.acv.gym.module.splash.SplashActivity
import com.acv.gym.module.weight.WeightActivity
import com.acv.gym.ui.commons.goToActivity
import com.acv.gym.ui.commons.setFadeInOutAnimation

infix fun ViewGroup.inflate(res: Int) = LayoutInflater.from(context).inflate(res, this, false)

inline fun <reified T : Activity> Activity.nav() {
    goToActivity<T>()
    setFadeInOutAnimation()
}

inline fun <reified T : Activity> Activity.menuNav(): Boolean {
    nav<T>()
    return true
}


fun Activity.inject() {
    when (this) {
        is ExerciseActivity -> GymApplication.appComponent.plus(ExerciseModule(this)).inject(this)
        is ExerciseTypeActivity -> GymApplication.appComponent.plus(ExerciseTypeModule(this)).inject(this)
        is MuscleGroupActivity -> GymApplication.appComponent.plus(MuscleGroupModule(this)).inject(this)
        is RoutineActivity -> GymApplication.appComponent.plus(RoutinesModule(this)).inject(this)
        is SessionActivity -> GymApplication.appComponent.plus(SessionModule(this)).inject(this)
        is SplashActivity -> GymApplication.appComponent.plus(SplashModule(this)).inject(this)
        is WeightActivity -> GymApplication.appComponent.plus(WeightModule(this)).inject(this)
        is RepActivity -> GymApplication.appComponent.plus(RepModule(this)).inject(this)
    }
}

fun MenuInflater.make(menuRes: Int, menu: Menu): Boolean {
    inflate(menuRes, menu)
    return true
}
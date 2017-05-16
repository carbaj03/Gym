package com.acv.gym.commons.extension

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.ViewGroup
import android.widget.SeekBar
import com.acv.gym.GymApplication
import com.acv.gym.commons.listener.SeekBarListener
import com.acv.gym.di.module.*
import com.acv.gym.module.exercise.ExerciseActivity
import com.acv.gym.module.exercise.type.ExerciseTypeActivity
import com.acv.gym.module.muscle.group.MuscleGroupActivity
import com.acv.gym.module.rep.RepActivity
import com.acv.gym.module.routine.RoutineActivity
import com.acv.gym.module.session.SessionActivity
import com.acv.gym.module.splash.SplashActivity
import com.acv.gym.module.weight.WeightActivity
import com.acv.gym.ui.commons.setSlideExitToRightAnimation
import com.acv.gym.ui.commons.setSlideRightAnimation
import katz.Option

infix fun ViewGroup.inflate(res: Int) = LayoutInflater.from(context).inflate(res, this, false)

inline fun <reified T : Activity> Activity.goToActivity(id: Option<String>) {
    val intent = Intent(this, T::class.java)
    id.map { intent.putExtra("ID", it) }
    startActivity(intent)
}

inline fun <reified T : Activity> Activity.nav(id: Option<String> = Option.None) {
    goToActivity<T>(id)
    finish()
    setSlideRightAnimation()
}

inline fun <reified T : Activity> Activity.navStack(id: Option<String> = Option.None) {
    goToActivity<T>(id)
    setSlideRightAnimation()
}

inline fun Activity.navBack() {
    finish()
    setSlideExitToRightAnimation()
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

fun SeekBar.listener(f: (Int) -> Unit) = setOnSeekBarChangeListener(SeekBarListener { f(it) })

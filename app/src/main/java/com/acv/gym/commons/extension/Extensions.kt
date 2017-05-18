package com.acv.gym.commons.extension

import android.app.Activity
import android.content.Intent
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.*
import android.widget.SeekBar
import android.widget.TextView
import com.acv.gym.GymApplication
import com.acv.gym.R
import com.acv.gym.commons.listener.SeekBarListener
import com.acv.gym.di.module.*
import com.acv.gym.domain.model.Model
import com.acv.gym.domain.model.MuscleGroup
import com.acv.gym.domain.usecase.Command
import com.acv.gym.module.exercise.ExerciseActivity
import com.acv.gym.module.exercise.ExercisesViewHolder
import com.acv.gym.module.exercise.type.ExerciseTypeActivity
import com.acv.gym.module.muscle.group.MuscleGroupActivity
import com.acv.gym.module.muscle.group.MuscleGroupViewHolder
import com.acv.gym.module.rep.RepActivity
import com.acv.gym.module.routine.RoutineActivity
import com.acv.gym.module.session.SessionActivity
import com.acv.gym.module.session.SessionViewHolder
import com.acv.gym.module.splash.SplashActivity
import com.acv.gym.module.weight.WeightActivity
import com.acv.gym.ui.commons.setSlideExitToRightAnimation
import com.acv.gym.ui.commons.setSlideRightAnimation

infix fun ViewGroup.inflate(res: Int) = LayoutInflater.from(context).inflate(res, this, false)

inline fun <reified T : Activity> Activity.goToActivity(pairs: List<Pair<String, Command>>) {
    val intent = Intent(this, T::class.java)
    pairs.map { intent.putExtra(it.first, it.second) }
    startActivity(intent)
}

inline fun <reified T : Activity> Activity.nav(pairs: List<Pair<String, Command>> = listOf()) {
    goToActivity<T>(pairs)
    finish()
    setSlideRightAnimation()
}

inline fun <reified T : Activity> Activity.navStack(pairs: List<Pair<String, Command>> = listOf()) {
    goToActivity<T>(pairs)
    setSlideRightAnimation()
}

inline fun Activity.navBack(): Boolean {
    finish()
    setSlideExitToRightAnimation()
    return true
}

inline fun <reified T : Activity> Activity.menuNav(): Boolean {
    nav<T>(listOf())
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

fun Activity.gridLayoutManager(cels : Int = 2) = GridLayoutManager(this, cels)

fun TextView.visible() { visibility = View.VISIBLE }
fun TextView.insivible() { visibility = View.INVISIBLE}

fun MenuInflater.make(menuRes: Int, menu: Menu): Boolean {
    inflate(menuRes, menu)
    return true
}

fun SeekBar.listener(f: (Int) -> Unit) = setOnSeekBarChangeListener(SeekBarListener { f(it) })

package com.acv.gym.module.splash

import com.acv.gym.R
import com.acv.gym.commons.extension.inject
import com.acv.gym.commons.extension.load
import com.acv.gym.commons.extension.visible
import com.acv.gym.data.db.room.RoomDB
import com.acv.gym.data.db.room.model.*
import com.acv.gym.module.session.SessionActivity
import com.acv.gym.presentation.module.splash.SplashPresenter
import com.acv.gym.presentation.module.splash.SplashView
import com.acv.gym.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_splash.*
import org.jetbrains.anko.doAsync

class SplashActivity : BaseActivity<SplashView, SplashPresenter>(), SplashView {
    override fun setupComponent() = inject()

    override fun getLayout() = R.layout.activity_splash

    override fun onCreate() {
        presenter.loadSplash()
        doAsync {

            RoomDB.instance.sessionExerciseDao().insertAll(
                    listOf(
                            SessionExerciseRoom("1", "Press Banca Plano", "1"),
                            SessionExerciseRoom("2", "Militar DB", "1"),
                            SessionExerciseRoom("3", "Press Inclinado DB", "1")
                    ))

            RoomDB.instance.sessionSetDao().insertAll(
                    listOf(
                            SessionSetRoom("1", 20f, 10, "1"),
                            SessionSetRoom("2", 25f, 10, "1"),
                            SessionSetRoom("3", 30f, 10, "1")
                    ))

            RoomDB.instance.muscleGroupDao().insertAll(
                    listOf(
                            MuscleGroupRoom("1", "Pecho"),
                            MuscleGroupRoom("2", "Espalda"),
                            MuscleGroupRoom("3", "Hombro"),
                            MuscleGroupRoom("4", "Triceps"),
                            MuscleGroupRoom("5", "Biceps"),
                            MuscleGroupRoom("6", "Cuadriceps"),
                            MuscleGroupRoom("7", "Isquios")
                    ))

            RoomDB.instance.exerciseTypeDao().insertAll(
                    listOf(
                            ExerciseTypeRoom("1", "Dumbell"),
                            ExerciseTypeRoom("2", "Bar"),
                            ExerciseTypeRoom("3", "Cable"),
                            ExerciseTypeRoom("4", "Body Weight"),
                            ExerciseTypeRoom("5", "Machine")
                    ))

            RoomDB.instance.exerciseDao().insertAll(
                    listOf(
                            ExerciseRoom("1", "Press inclinado", "1"),
                            ExerciseRoom("2", "Press banca", "1"),
                            ExerciseRoom("3", "Curl", "1"),
                            ExerciseRoom("4", "Remo", "1")
                    ))

        }
        logoApp.setOnClickListener { load<SessionActivity>(listOf()) }
    }

    override fun show(data: List<Any>) = logoApp.visible()

    override fun showNetworkError() = TODO()

    override fun showServerError() = TODO()
}

package com.acv.gym.module.routine

import com.acv.gym.R
import com.acv.gym.presentation.module.routine.RoutinePresenter
import com.acv.gym.presentation.module.routine.RoutineView
import com.acv.gym.ui.BaseActivity

class RoutineActivity : BaseActivity<RoutineView, RoutinePresenter>() {
    override fun getLayout() = R.layout.activity_routines

    override fun onCreate() {
        presenter.loadRoutines()
    }
}

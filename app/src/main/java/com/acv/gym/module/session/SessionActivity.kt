package com.acv.gym.module.session

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutCompat
import android.support.v7.widget.LinearLayoutManager
import com.acv.gym.GymApplication
import com.acv.gym.R
import com.acv.gym.di.module.RoutinesModule
import com.acv.gym.di.module.SessionModule
import com.acv.gym.domain.model.RoutineModel
import com.acv.gym.domain.model.SessionExerciseModel
import com.acv.gym.module.routines.RoutinesAdapter
import com.acv.gym.presentation.routine.RoutinesPresenter
import com.acv.gym.presentation.routine.RoutinesView
import com.acv.gym.presentation.session.SessionPresenter
import com.acv.gym.presentation.session.SessionView
import com.acv.gym.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_routines.*
import javax.inject.Inject

class SessionActivity : BaseActivity(), SessionView {
    @Inject lateinit var presenter: SessionPresenter

    override fun setupActivityComponent() {
        GymApplication.appComponent.plus(SessionModule(this)).inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.attachView(this)
//        presenter.loadRoutines()
    }

    override fun getActivityLayout() = R.layout.activity_routines

    override fun show(sessionExercise: List<SessionExerciseModel>) {
//        rvRoutines.layoutManager = LinearLayoutManager(this)
//        rvRoutines.adapter = RoutinesAdapter(sessionExercise) { routine ->
//            presenter.checkRoutines(routine)
//        }
    }

    override fun renderNetworkError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun renderServerError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

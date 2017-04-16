package com.acv.gym.module.routine

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.acv.gym.GymApplication
import com.acv.gym.R
import com.acv.gym.di.module.RoutinesModule
import com.acv.gym.domain.model.RoutineModel
import com.acv.gym.presentation.module.routine.RoutinePresenter
import com.acv.gym.presentation.module.routine.RoutineView
import com.acv.gym.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_routines.*
import javax.inject.Inject

class RoutineActivity : BaseActivity(), RoutineView {
    @Inject lateinit var presenter: RoutinePresenter

    override fun setupActivityComponent() {
        GymApplication.appComponent.plus(RoutinesModule(this)).inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.attachView(this)
        presenter.loadRoutines()
    }

    override fun getActivityLayout() = R.layout.activity_routines

    override fun show(routines: List<RoutineModel>) {
        rvRoutines.layoutManager = GridLayoutManager(this, 2)
        rvRoutines.adapter = RoutineAdapter(routines) {
            presenter.checkRoutines(it)
        }
    }

    override fun renderNetworkError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun renderServerError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun goToTemplate(id: String) {
//        navigator.navigateToTemplate(id)
    }
}

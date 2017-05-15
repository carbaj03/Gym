package com.acv.gym.module.routine

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.acv.gym.R
import com.acv.gym.commons.extension.inject
import com.acv.gym.domain.model.Routine
import com.acv.gym.presentation.module.routine.RoutinePresenter
import com.acv.gym.presentation.module.routine.RoutineView
import com.acv.gym.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_routines.*

class RoutineActivity : BaseActivity<RoutineView, RoutinePresenter>(), RoutineView {
    override fun setupComponent() = inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.loadRoutines()
    }

    override fun getLayout() = R.layout.activity_routines

    override fun show(routines: List<Routine>) {
        rvRoutines.layoutManager = GridLayoutManager(this, 2)
        rvRoutines.adapter = RoutineAdapter(routines) {
            presenter.checkRoutines(it)
        }
    }

    override fun showNetworkError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showServerError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun goToTemplate(id: String) {
//        navigator.navigateToTemplate(id)
    }
}

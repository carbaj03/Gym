package com.acv.gym.module.routine

import com.acv.gym.R
import com.acv.gym.commons.extension.inject
import com.acv.gym.commons.extension.gridLayoutManager
import com.acv.gym.domain.model.Routine
import com.acv.gym.presentation.module.routine.RoutinePresenter
import com.acv.gym.presentation.module.routine.RoutineView
import com.acv.gym.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_routines.*

class RoutineActivity : BaseActivity<RoutineView, RoutinePresenter>(), RoutineView {
    override fun setupComponent() = inject()

    override fun getLayout() = R.layout.activity_routines

    override fun createView() = presenter.loadRoutines()

    override fun show(routines: List<Routine>) = with(rvRoutines) {
        layoutManager = gridLayoutManager()
        adapter = RoutineAdapter(routines) {
            presenter.checkRoutines(it)
        }
    }

    override fun showNetworkError() = TODO("not implemented")

    override fun showServerError() = TODO("not implemented")

    override fun goToTemplate(id: String) {
//        navigator.navigateToTemplate(id)
    }
}

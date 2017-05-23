package com.acv.gym.module.splash

import com.acv.gym.R
import com.acv.gym.commons.extension.inject
import com.acv.gym.commons.extension.nav
import com.acv.gym.commons.extension.visible
import com.acv.gym.data.db.room.RoomDB
import com.acv.gym.data.db.room.model.SessionExerciseDataModel
import com.acv.gym.data.db.room.model.SessionSetDataModel
import com.acv.gym.module.session.SessionActivity
import com.acv.gym.presentation.module.splash.SplashPresenter
import com.acv.gym.presentation.module.splash.SplashView
import com.acv.gym.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_splash.*
import org.jetbrains.anko.doAsync

class SplashActivity : BaseActivity<SplashView, SplashPresenter>(), SplashView {
    override fun setupComponent() = inject()

    override fun getLayout() = R.layout.activity_splash

    override fun createView() {
        presenter.loadSplash()
        doAsync {

            RoomDB.instance.exerciseDao().insertAll(
                    listOf(
                            SessionExerciseDataModel(
                                    "1",
                                    "Press Banca Plano",
                                    //                                listOf(
//                                        SessionSetDataModel("1", 20f, 10, ""),
//                                        SessionSetDataModel("2", 20f, 10, "")
//                                ),
                                    "1"
                            ),
                            SessionExerciseDataModel(
                                    "2",
                                    "Militar DB",
                                    //                                listOf(
//                                        SessionSetDataModel("1", 20f, 10, ""),
//                                        SessionSetDataModel("2", 20f, 10, "")
//                                ),
                                    "1"
                            )
                            ,
                            SessionExerciseDataModel(
                                    "3",
                                    "Press Inclinado DB",
                                    //                                listOf(
//                                        SessionSetDataModel("1", 20f, 10, ""),
//                                        SessionSetDataModel("2", 20f, 10, "")
//                                ),
                                    "1")
                    ))
        }
        logoApp.setOnClickListener { nav<SessionActivity>(listOf()) }
    }

    override fun show(data: List<Any>) = logoApp.visible()

    override fun showNetworkError() = TODO()

    override fun showServerError() = TODO()
}

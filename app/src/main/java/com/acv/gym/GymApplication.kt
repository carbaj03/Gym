package com.acv.gym


import android.app.Application

import com.acv.gym.di.component.AppComponent
import com.acv.gym.di.component.DaggerAppComponent
import com.acv.gym.di.module.AppModule

class GymApplication : Application() {
    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = initializeDagger()
    }

    fun initializeDagger() = DaggerAppComponent.builder().appModule(AppModule(this)).build()

}

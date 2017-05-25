package com.acv.gym


import android.app.Application
import com.acv.gym.data.db.room.RoomDB
import com.acv.gym.di.component.AppComponent
import com.acv.gym.di.component.DaggerAppComponent
import com.acv.gym.di.module.AppModule
import io.realm.Realm

class GymApplication : Application() {
    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = initializeDagger()
        Realm.init(this)
        RoomDB.create(this)
    }

    fun initializeDagger() = DaggerAppComponent.builder().appModule(AppModule(this)).build()

}

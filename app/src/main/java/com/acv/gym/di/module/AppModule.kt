package com.acv.gym.di.module


import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import com.acv.gym.GymApplication
import com.acv.gym.data.GymGatewayImpl
import com.acv.gym.data.db.GymDataSource
import com.acv.gym.data.db.room.AppDatabase
import com.acv.gym.data.db.room.datasource.GymRoom
import com.acv.gym.domain.GymGateway
import com.acv.gym.domain.invoker.ServiceInvokerImp
import com.acv.gym.presentation.invoker.ServiceInvoker
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val application: GymApplication) {

    @Provides
    @Singleton
    fun provideApplicationContext(): Context = application.applicationContext

    @Singleton
    @Provides
    fun provideDb(app: Application): AppDatabase =
            Room.databaseBuilder(app, AppDatabase::class.java, "gym.db").build()

//    @Singleton
//    @Provides
//    fun provideUserDao(db: AppDatabase): SessionExerciseDao = db.exerciseDao()

    @Singleton @Provides
    fun provideInteractorInvoker(): ServiceInvoker = ServiceInvokerImp()

    @Singleton
    @Provides
    fun provideGateway(dataSource: GymDataSource): GymGateway = GymGatewayImpl(dataSource)

    @Singleton
    @Provides
    fun provideDataSource(): GymDataSource = GymRoom()
}

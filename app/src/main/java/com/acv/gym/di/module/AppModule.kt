package com.acv.gym.di.module


import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import com.acv.gym.GymApplication
import com.acv.gym.data.db.room.AppDatabase
import com.acv.gym.data.db.room.ExerciseDao
import com.acv.gym.data.db.room.SessionExerciseDao
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

    @Singleton
    @Provides
    fun provideUserDao(db: AppDatabase): SessionExerciseDao = db.exerciseDao()
}

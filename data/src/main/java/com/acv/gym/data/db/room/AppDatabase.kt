package com.acv.gym.data.db.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = arrayOf(SessionExerciseDataModel::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun exerciseDao(): SessionExerciseDao
}
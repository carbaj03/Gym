package com.acv.gym.data.db.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.acv.gym.data.db.room.model.*

@Database(entities =
arrayOf(
        SessionExerciseDataModel::class,
        SessionSetDataModel::class
), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun sessionExerciseDao(): SessionExerciseDao
    abstract fun exerciseDao(): ExerciseDao
    abstract fun sessionSetDao(): SessionSetDao
}
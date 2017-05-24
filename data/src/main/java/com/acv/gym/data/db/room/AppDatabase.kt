package com.acv.gym.data.db.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.acv.gym.data.db.room.model.*

@Database(entities =
arrayOf(
        SessionExerciseRoom::class,
        SessionSetRoom::class,
        ExerciseRoom::class,
        ExerciseTypeRoom::class,
        MuscleGroupRoom::class,
        SessionRoom::class
), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun sessionDao(): SessionDao
    abstract fun sessionExerciseDao(): SessionExerciseDao
    abstract fun sessionSetDao(): SessionSetDao
    abstract fun exerciseDao(): ExerciseDao
    abstract fun exerciseTypeDao(): ExerciseTypeDao
    abstract fun muscleGroupDao(): MuscleGroupDao
}
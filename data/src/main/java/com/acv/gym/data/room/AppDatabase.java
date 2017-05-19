package com.acv.gym.data.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {ExerciseDataModel.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ExerciseDao userDao();
}
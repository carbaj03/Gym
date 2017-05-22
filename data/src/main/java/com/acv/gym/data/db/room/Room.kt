package com.acv.gym.data.db.room

import android.arch.persistence.room.Room
import android.content.Context

/**
 * Created by alejandro on 21/05/2017.
 */
class RoomDB{
    companion object {
        lateinit var instance: AppDatabase
            private set

        fun create(context: Context) {
            instance = Room.databaseBuilder(context, AppDatabase::class.java, "gym.db").build()
        }
    }
}
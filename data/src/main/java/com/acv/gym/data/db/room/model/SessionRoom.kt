package com.acv.gym.data.db.room.model

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.Query
import com.acv.gym.data.DataModel
import com.acv.gym.domain.model.Session

const val tableSession = "session"

@Entity(tableName = tableSession)
data class SessionRoom(
        @PrimaryKey var id: String,
        var name: String
) : DataModel {
    constructor() : this("", "")
}

fun SessionRoom.map() = Session(id, name)
fun Session.map() = SessionRoom(id, name)

@Dao interface SessionDao {
    @Query("Select * FROM $tableSession")
    fun getAll(): List<SessionRoom>
}
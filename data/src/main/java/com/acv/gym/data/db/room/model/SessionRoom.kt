package com.acv.gym.data.db.room.model

import android.arch.persistence.room.*
import com.acv.gym.data.DataModel
import com.acv.gym.domain.model.Session
import com.acv.gym.domain.usecase.Id
import java.util.*

const val tableSession = "session"

@Entity(tableName = tableSession)
data class SessionRoom(
        @PrimaryKey var id: String,
        var name: String,
        var date: Date
) : DataModel {
    constructor() : this(UUID.randomUUID().toString(), "", Date())
}

fun SessionRoom.map() = Session(Id(id), name, date)
fun Session.map() = SessionRoom(id.value, name, date)

@Dao interface SessionDao {
    @Query("SELECT * FROM $tableSession")
    fun getAll(): List<SessionRoom>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(listOf: List<SessionRoom>)
}
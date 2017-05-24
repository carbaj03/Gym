package com.acv.gym.data.db.room.model

import android.arch.persistence.room.*
import com.acv.gym.data.DataModel
import com.acv.gym.domain.model.SessionExercise


const val tableSessionExercises = "session_exercise"

@Entity(tableName = tableSessionExercises)
data class SessionExerciseRoom(
        @PrimaryKey var id: String,
        var exercise: String,
        var session: String
) : DataModel {
    constructor() : this("", "", /*listOf(), */"")
}

fun SessionExerciseRoom.map() = SessionExercise(id, exercise, /*sets.map { it.map() },*/ listOf(), session)
fun SessionExercise.map() = SessionExerciseRoom(id, exercise, /*sets.map { it.map() }, */session)

@Dao
interface SessionExerciseDao {
    @Query("SELECT * FROM $tableSessionExercises")
    fun getAll(): List<SessionExerciseRoom>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(session: List<SessionExerciseRoom>)
}
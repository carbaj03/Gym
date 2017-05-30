package com.acv.gym.data.db.room.model

import android.arch.persistence.room.*
import com.acv.gym.data.DataModel
import com.acv.gym.domain.model.SessionExercise
import com.acv.gym.domain.usecase.Id
import java.util.*


const val tableSessionExercises = "session_exercise"

@Entity(tableName = tableSessionExercises,
        foreignKeys = arrayOf(
                ForeignKey(
                        entity = SessionRoom::class,
                        parentColumns = arrayOf("id"),
                        childColumns = arrayOf("session"),
                        onDelete = ForeignKey.CASCADE),
                ForeignKey(
                        entity = ExerciseRoom::class,
                        parentColumns = arrayOf("id"),
                        childColumns = arrayOf("exercise"),
                        onDelete = ForeignKey.CASCADE))
)
data class SessionExerciseRoom(
        @PrimaryKey var id: String,
        var exercise: String,
        var session: String
) : DataModel {
    constructor() : this(UUID.randomUUID().toString(), "", "")
}

fun SessionExerciseRoom.map() = SessionExercise(Id(id), Id(exercise), listOf(), Id(session))
fun SessionExercise.map() = SessionExerciseRoom(id.value, exercise.value, session.value)

@Dao
interface SessionExerciseDao {
    @Query("SELECT * FROM $tableSessionExercises")
    fun getAll(): List<SessionExerciseRoom>

    @Query("""
    SELECT *
    FROM $tableSessionExercises
    INNER JOIN $tableSession ON session = $tableSession.id
    WHERE session = :arg0 """)
    fun getBySession(id: String): List<SessionExerciseRoom>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(session: List<SessionExerciseRoom>)
}
package com.acv.gym.data.db.room.model

import android.arch.persistence.room.*
import com.acv.gym.data.DataModel
import com.acv.gym.domain.model.Exercise
import com.acv.gym.domain.model.session.SessionExercise
import com.acv.gym.domain.model.session.SessionExerciseId
import com.acv.gym.domain.service.Id
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
        var session: String,
        var name: String
) : DataModel {
    constructor() : this(SessionExerciseId().value, "", "", "")
}

fun SessionExerciseRoom.map() = SessionExercise(SessionExerciseId(id), Exercise(exercise, name, "", ""), listOf(), Id(session))
fun SessionExercise.map() = SessionExerciseRoom(id.value, exercise.id, session.value, exercise.name)

@Dao interface SessionExerciseDao {
    @Query("SELECT * FROM $tableSessionExercises")
    fun getAll(): List<SessionExerciseRoom>

    @Query("""
    SELECT session_exercise.id, session_exercise.exercise, session_exercise.session, exercise.name
    FROM $tableSessionExercises
    INNER JOIN $tableSession ON session = $tableSession.id
    INNER JOIN $tableExercise ON exercise = $tableExercise.id
    WHERE session = :arg0 """)
    fun getBySession(id: String): List<SessionExerciseRoom>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(session: List<SessionExerciseRoom>)
}
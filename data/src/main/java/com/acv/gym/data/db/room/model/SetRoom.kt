package com.acv.gym.data.db.room.model

import android.arch.persistence.room.*
import com.acv.gym.data.DataModel
import com.acv.gym.domain.model.session.SessionExerciseId
import com.acv.gym.domain.model.session.Set
import com.acv.gym.domain.model.session.SetId
import com.acv.gym.domain.service.Id
import java.util.*


const val tableSessionSet = "session_set"

@Entity(tableName = tableSessionSet,
        foreignKeys = arrayOf(
                ForeignKey(
                        entity = SessionExerciseRoom::class,
                        parentColumns = arrayOf("id"),
                        childColumns = arrayOf("sessionExercise"),
                        onDelete = ForeignKey.CASCADE))
)
data class SessionSetRoom(
        @PrimaryKey var id: String,
        var weight: Float,
        var reps: Int,
        var sessionExercise: String
) : DataModel {
    constructor() : this(SetId().value, 0f, 0, "")
}

fun SessionSetRoom.map() = Set(SetId(id), weight, reps, SessionExerciseId(sessionExercise))
fun Set.map() = SessionSetRoom(id.value, weight, reps, sessionExercise.value)

@Dao interface SessionSetDao {
    @Query("SELECT * FROM $tableSessionSet")
    fun getAll(): List<SessionSetRoom>

    @Query("""
    SELECT *
    FROM $tableSessionSet
    INNER JOIN $tableSessionExercises ON sessionExercise = $tableSessionExercises.id
    WHERE sessionExercise = :arg0 """)
    fun getBySessionExercise(id: String): List<SessionSetRoom>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(session: List<SessionSetRoom>)
}
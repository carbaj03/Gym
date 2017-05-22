package com.acv.gym.data.db.room

import android.arch.persistence.room.*
import com.acv.gym.data.DataModel
import com.acv.gym.domain.model.SessionExercise
import io.realm.annotations.PrimaryKey


const val table = "exercises"

@Entity(tableName = table)
data class SessionExerciseDataModel(
        @PrimaryKey var id: String
        , var exercise: String
        , var sets: List<SessionSetDataModel>
        , var session: String
) : DataModel

fun SessionExerciseDataModel.map() = SessionExercise(id, exercise, sets.map { it.map() }, session)
fun SessionExercise.map() = SessionExerciseDataModel(id, exercise, sets.map { it.map() }, session)

@Dao
interface SessionExerciseDao {

    @Query("SELECT * FROM $table")
    fun getAll(): List<SessionExerciseDataModel>

    @Query("SELECT * FROM $table WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<SessionExerciseDataModel>

    @Query("SELECT * FROM $table WHERE first_name LIKE :first AND last_name LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): SessionExerciseDataModel

    @Insert
    fun insertAll(vararg users: SessionExerciseDataModel)

    @Delete
    fun delete(user: SessionExerciseDataModel)
}
package com.acv.gym.data.db.room.model

import android.arch.persistence.room.*
import com.acv.gym.data.DataModel
import com.acv.gym.domain.model.SessionExercise


const val tableExercises = "exercises"

@Entity(tableName = tableExercises)
data class SessionExerciseDataModel(
        @PrimaryKey var id: String
        , var exercise: String
//        , val sets: List<SessionSetDataModel>
        , var session: String
) : DataModel {
    constructor() : this("", "", "")
}

fun SessionExerciseDataModel.map() = SessionExercise(id, exercise, listOf(), /*sets.map { it.map() },*/ session)
fun SessionExercise.map() = SessionExerciseDataModel(id, exercise, /* sets.map { it.map() }*/ session)

@Dao
interface SessionExerciseDao {

    @Query("SELECT * FROM ${tableExercises}")
    fun getAll(): List<SessionExerciseDataModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(session: List<SessionExerciseDataModel>)

}
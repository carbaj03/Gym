package com.acv.gym.data.db.room.model

import android.arch.persistence.room.*
import com.acv.gym.data.DataModel
import com.acv.gym.domain.model.Exercise
import com.acv.gym.domain.model.SessionExercise


const val tableExercise = "exercise"

@Entity(tableName = tableExercise)
data class ExerciseDataModel(
        @PrimaryKey var id: String
        , var name: String
) : DataModel {
    constructor() : this("", "")
}

fun ExerciseDataModel.map() = Exercise(id, name)
fun Exercise.map() = ExerciseDataModel(id, name)

@Dao
interface ExerciseDao {

    @Query("SELECT * FROM $tableExercise")
    fun getAll(): List<ExerciseDataModel>

    @Query("SELECT * FROM $tableExercise WHERE id = :id")
    fun getBy(id: String): List<ExerciseDataModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(exercises: List<ExerciseDataModel>)

}
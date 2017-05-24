package com.acv.gym.data.db.room.model

import android.arch.persistence.room.*
import com.acv.gym.data.DataModel
import com.acv.gym.domain.model.Exercise


const val tableExercise = "exercise"

@Entity(tableName = tableExercise,
        foreignKeys = arrayOf(
                ForeignKey(
                        entity = ExerciseTypeRoom::class,
                        parentColumns = arrayOf("id"),
                        childColumns = arrayOf("exerciseType"),
                        onDelete = ForeignKey.CASCADE)),
        indices = arrayOf(Index(value = "exerciseType")))
data class ExerciseRoom(
        @PrimaryKey var id: String,
        var name: String,
        var exerciseType: String

) : DataModel {
    constructor() : this("", "", "")
}

fun ExerciseRoom.map() = Exercise(id, name, exerciseType)
fun Exercise.map() = ExerciseRoom(id, name, exerciseType)

@Dao
interface ExerciseDao {

    @Query("SELECT * FROM $tableExercise")
    fun getAll(): List<ExerciseRoom>

    @Query("SELECT * FROM $tableExercise WHERE exerciseType = :arg0")
    fun getBy(id: String): List<ExerciseRoom>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(exercises: List<ExerciseRoom>)
}
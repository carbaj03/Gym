package com.acv.gym.data.db.room.model

import android.arch.persistence.room.*
import com.acv.gym.data.DataModel
import com.acv.gym.domain.model.exercise.Exercise
import com.acv.gym.domain.model.exercise.ExerciseId
import java.util.*


const val tableExercise = "exercise"

@Entity(tableName = tableExercise,
        foreignKeys = arrayOf(
                ForeignKey(
                        entity = ExerciseTypeRoom::class,
                        parentColumns = arrayOf("id"),
                        childColumns = arrayOf("exerciseType"),
                        onDelete = ForeignKey.CASCADE
                ),
                ForeignKey(
                        entity = MuscleGroupRoom::class,
                        parentColumns = arrayOf("id"),
                        childColumns = arrayOf("muscleGroup"),
                        onDelete = ForeignKey.CASCADE
                )
        ))
data class ExerciseRoom(
        @PrimaryKey var id: String,
        var name: String,
        var exerciseType: String,
        var muscleGroup: String

) : DataModel {
    constructor() : this(UUID.randomUUID().toString(), "", "", "")
}

fun ExerciseRoom.map() = Exercise(ExerciseId(id), name, exerciseType, muscleGroup)
fun Exercise.map() = ExerciseRoom(id.value, name, exerciseType, muscleGroup)

@Dao
interface ExerciseDao {
    @Query("SELECT * FROM $tableExercise")
    fun getAll(): List<ExerciseRoom>

    @Query("SELECT * FROM $tableExercise WHERE muscleGroup = :arg0")
    fun getByMuscleGroup(id: String): List<ExerciseRoom>

    @Query("SELECT * FROM $tableExercise WHERE exerciseType = :arg0")
    fun getByExerciseType(id: String): List<ExerciseRoom>

    @Query("SELECT * FROM $tableExercise WHERE muscleGroup = :arg0 AND exerciseType = :arg1")
    fun getBy(idMuscleGroup: String, idExerciseType: String): List<ExerciseRoom>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(exercises: List<ExerciseRoom>)
}
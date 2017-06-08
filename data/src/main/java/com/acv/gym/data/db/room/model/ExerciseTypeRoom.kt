package com.acv.gym.data.db.room.model

import android.arch.persistence.room.*
import com.acv.gym.data.DataModel
import com.acv.gym.domain.model.ExerciseType
import java.util.*


const val tableExerciseType = "exercise_type"

@Entity(tableName = tableExerciseType)
data class ExerciseTypeRoom(
        @PrimaryKey var id: String,
        var name: String
) : DataModel {
    constructor() : this(UUID.randomUUID().toString(), "")
}

fun ExerciseTypeRoom.map() = ExerciseType(id, name)
fun ExerciseType.map() = ExerciseTypeRoom(id, name)

@Dao
interface ExerciseTypeDao {
    @Query("SELECT * FROM $tableExerciseType")
    fun getAll(): List<ExerciseTypeRoom>

    @Query("""SELECT $tableExerciseType.id, $tableExerciseType.name
            FROM $tableExerciseType
            INNER JOIN $tableExercise ON exerciseType = $tableExerciseType.id
            WHERE exercise.muscleGroup = :arg0
            GROUP BY exercise.exerciseType
            """)
    fun getBy(idMuscleGroup: String): List<ExerciseTypeRoom>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(listOf: List<ExerciseTypeRoom>)
}
package com.acv.gym.data.db.room.model

import android.arch.persistence.room.*
import com.acv.gym.data.DataModel
import com.acv.gym.domain.model.ExerciseType


const val tableExerciseType = "exercise_type"

@Entity(tableName = tableExerciseType)
data class ExerciseTypeRoom(
        @PrimaryKey var id: String,
        var name: String
) : DataModel {
    constructor() : this("", "")
}

fun ExerciseTypeRoom.map() = ExerciseType(id, name)
fun ExerciseType.map() = ExerciseTypeRoom(id, name)

@Dao
interface ExerciseTypeDao {
    @Query("SELECT * FROM $tableExerciseType")
    fun getAll(): List<ExerciseTypeRoom>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(listOf: List<ExerciseTypeRoom>)
}
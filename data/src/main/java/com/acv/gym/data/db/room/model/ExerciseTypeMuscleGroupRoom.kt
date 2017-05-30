package com.acv.gym.data.db.room.model

import android.arch.persistence.room.*
import com.acv.gym.data.DataModel
import com.acv.gym.domain.model.Exercise
import com.acv.gym.domain.model.SessionExercise
import java.util.*


const val tableExeserciseTypeMuscleGroup= "exercise_type_muscle_group"

@Entity(tableName = tableExeserciseTypeMuscleGroup,
        foreignKeys = arrayOf(
                ForeignKey(
                        entity = MuscleGroupRoom::class,
                        parentColumns = arrayOf("id"),
                        childColumns = arrayOf("muscleGroup"),
                        onDelete = ForeignKey.CASCADE),
                ForeignKey(
                        entity = ExerciseTypeRoom::class,
                        parentColumns = arrayOf("id"),
                        childColumns = arrayOf("exerciseType"),
                        onDelete = ForeignKey.CASCADE)))
data class ExerciseTypeMuscleGroupRoom(
        @PrimaryKey var id: String,
        var exerciseType: String,
        var muscleGroup: String
) : DataModel {
    constructor() : this("", "", "")
}


@Dao
interface ExerciseTypeMuscleGroupDao {
    @Query("""SELECT exercise_type.id, exercise_type.name
            FROM $tableExeserciseTypeMuscleGroup
            INNER JOIN $tableMuscleGroup ON muscleGroup = $tableMuscleGroup.id
            INNER JOIN $tableExerciseType ON exerciseType = $tableExerciseType.id
            WHERE muscleGroup = :arg0 """)
    fun getExerciseTypeBy(id: String): List<ExerciseTypeRoom>

    @Query("""SELECT muscle_group.id, muscle_group.name
            FROM $tableExeserciseTypeMuscleGroup
            INNER JOIN $tableMuscleGroup ON muscleGroup = $tableMuscleGroup.id
            INNER JOIN $tableExerciseType ON exerciseType = $tableExerciseType.id
            WHERE exerciseType = :arg0 """)
    fun getMuscleGroupBy(id: String): List<MuscleGroupRoom>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(session: List<SessionExerciseRoom>): List<Long>
}
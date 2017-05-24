package com.acv.gym.data.db.room.model

import android.arch.persistence.room.*
import com.acv.gym.data.DataModel
import com.acv.gym.domain.model.MuscleGroup


const val tableMuscleGroup = "muscle_group"

@Entity(tableName = tableMuscleGroup)
data class MuscleGroupRoom(
        @PrimaryKey var id: String,
        var name: String
) : DataModel {
    constructor() : this("", "")
}

fun MuscleGroupRoom.map() = MuscleGroup(id, name)
fun MuscleGroup.map() = MuscleGroupRoom(id, name)

@Dao interface MuscleGroupDao {
    @Query("SELECT * FROM $tableMuscleGroup")
    fun getAll(): List<MuscleGroupRoom>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(muscleGroups: List<MuscleGroupRoom>)

}

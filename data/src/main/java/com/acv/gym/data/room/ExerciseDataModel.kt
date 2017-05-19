package com.acv.gym.data.room

import android.arch.persistence.room.*
import com.acv.gym.data.DataModel
import com.acv.gym.data.realm.model.ExerciseDataModel
import com.acv.gym.domain.model.Exercise


const val table = "exercises"

@Entity(tableName = table)
data class ExerciseDataModel(
        @PrimaryKey var id: String,
        var name: String
) : DataModel

fun ExerciseDataModel.map() = Exercise(id, name)

@Dao
interface ExerciseDao {

    @Query("SELECT * FROM $table")
    fun getAll(): List<ExerciseDataModel>

    @Query("SELECT * FROM $table WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<ExerciseDataModel>

    @Query("SELECT * FROM $table WHERE first_name LIKE :first AND last_name LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): ExerciseDataModel

    @Insert
    fun insertAll(vararg users: ExerciseDataModel)

    @Delete
    fun delete(user: ExerciseDataModel)
}
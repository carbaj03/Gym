package com.acv.gym.data.db.room.model

import android.arch.persistence.room.*
import com.acv.gym.data.DataModel
import com.acv.gym.domain.model.SessionSet


const val tableSessionSet = "session_set"

@Entity(tableName = tableSessionSet)
data class SessionSetDataModel(
        @PrimaryKey var id: String
        , var weight: Float
        , var reps: Int
        , var sessionExercise: String
) : DataModel {
    constructor() : this("", 0f, 0, "")
}


fun SessionSetDataModel.map() = SessionSet(id, weight, reps, sessionExercise)
fun SessionSet.map() = SessionSetDataModel(id, weight, reps, sessionExercise)

@Dao
interface SessionSetDao {

    @Query("SELECT * FROM ${tableSessionSet}")
    fun getAll(): List<SessionSetDataModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(session: List<SessionSetDataModel>)

}
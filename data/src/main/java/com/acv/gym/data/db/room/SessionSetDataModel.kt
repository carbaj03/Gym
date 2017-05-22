package com.acv.gym.data.db.room

import android.arch.persistence.room.PrimaryKey
import com.acv.gym.data.DataModel
import com.acv.gym.domain.model.SessionSet


open class SessionSetDataModel(
        @PrimaryKey var id: String
        , var weight: Float
        , var reps: Int
        , var sessionExercise: String
) : DataModel

fun SessionSetDataModel.map() = SessionSet(id, weight, reps, sessionExercise)
fun SessionSet.map() = SessionSetDataModel(id, weight, reps, sessionExercise)
//fun List<SessionSet>.map() = mapTo(RealmList<SessionSetDataModel>(), { x: SessionSet -> x.map() })
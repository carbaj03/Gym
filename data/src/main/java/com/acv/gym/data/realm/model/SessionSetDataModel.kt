package com.acv.gym.data.realm.model

import com.acv.gym.data.DataModel
import com.acv.gym.domain.model.SessionSet
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey


open class SessionSetDataModel(
        @PrimaryKey var id: String
        , var weight: Float
        , var reps: Int
        , var sessionExercise: String
) : RealmObject(), DataModel {
    constructor() : this("", 0f, 0, "")
}

fun SessionSetDataModel.map() = SessionSet(id, weight, reps, sessionExercise)
fun SessionSet.map() = SessionSetDataModel(id, weight, reps, sessionExercise)
fun List<SessionSet>.map() = mapTo(RealmList<SessionSetDataModel>(), { x: SessionSet -> x.map() })
package com.acv.gym.data.db.realm.model

import com.acv.gym.data.DataModel
import com.acv.gym.domain.model.session.Set
import com.acv.gym.domain.service.Id
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

fun SessionSetDataModel.map() = Set(Id(id), weight, reps, Id(sessionExercise))
fun Set.map() = SessionSetDataModel(id.value, weight, reps, sessionExercise.value)
fun List<Set>.map() = mapTo(RealmList<SessionSetDataModel>(), { x: Set -> x.map() })
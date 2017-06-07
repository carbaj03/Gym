package com.acv.gym.data.db.realm.model

import com.acv.gym.data.DataModel
import com.acv.gym.domain.model.SessionExercise
import com.acv.gym.domain.usecase.Id
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class SessionExerciseDataModel(
        @PrimaryKey var id: String
        , var exercise: String
        , var sets: RealmList<SessionSetDataModel>
        , var session: String
) : RealmObject(), DataModel {
    constructor() : this("", "", RealmList(), "")
}

//fun SessionExerciseDataModel.map() = SessionExercise(Id(id), Id(exercise), sets.map { it.map() }, Id(session))
//fun SessionExercise.map() = SessionExerciseDataModel(id.value, exercise.value, sets.map(), session.value)
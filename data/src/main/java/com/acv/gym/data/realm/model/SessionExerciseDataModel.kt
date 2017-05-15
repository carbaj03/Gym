package com.acv.gym.data.realm.model

import com.acv.gym.data.DataModel
import com.acv.gym.domain.model.SessionExercise
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class SessionExerciseDataModel(
        @PrimaryKey var id: String
        , var exercise: String
        , var sets: RealmList<SessionSetDataModel>
        , var session: String
) : RealmObject(), DataModel

fun SessionExerciseDataModel.map() = SessionExercise(id, exercise, sets.map { it.map() }, session)
fun SessionExercise.map() = SessionExerciseDataModel(id, exercise, sets.map(), session)
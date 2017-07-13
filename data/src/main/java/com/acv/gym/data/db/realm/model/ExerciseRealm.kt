package com.acv.gym.data.db.realm.model

import com.acv.gym.data.DataModel
import com.acv.gym.domain.model.Exercise
import com.acv.gym.domain.model.ExerciseId
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey


open class ExerciseRealm(
        @PrimaryKey var id: String,
        var name: String,
        var exerciseType: String,
        var muscleGroup: String
) : RealmObject(), DataModel {
    constructor() : this("", "", "", "")
}

fun ExerciseRealm.map() = Exercise(ExerciseId(id), name, exerciseType, muscleGroup)
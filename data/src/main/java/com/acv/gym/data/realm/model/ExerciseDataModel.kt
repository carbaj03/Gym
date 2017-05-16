package com.acv.gym.data.realm.model

import com.acv.gym.data.DataModel
import com.acv.gym.domain.model.Exercise
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey


open class ExerciseDataModel(
        @PrimaryKey var id: String,
        var name: String
) : RealmObject(), DataModel {
    constructor(): this("", "")
}

fun ExerciseDataModel.map() = Exercise(id, name)
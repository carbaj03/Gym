package com.acv.gym.data

import com.acv.gym.data.model.DataModel
import com.acv.gym.data.model.RoutineDataModel

interface DataSource<out T: DataModel> {
    fun getAll(): List<T>
}

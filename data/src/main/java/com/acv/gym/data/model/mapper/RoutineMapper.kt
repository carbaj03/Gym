package com.acv.gym.data.model.mapper

import com.acv.gym.data.model.RoutineDataModel
import com.acv.gym.domain.mapper.Mapper
import com.acv.gym.domain.model.RoutineModel


class RoutineMapper : Mapper<RoutineDataModel, RoutineModel> {
    override fun map(input: RoutineDataModel) = with(input) {
        RoutineModel(id, name, image)
    }
}
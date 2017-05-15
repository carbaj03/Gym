package com.acv.gym.data.model.mapper

import com.acv.gym.data.model.RoutineDataModel
import com.acv.gym.domain.mapper.Mapper
import com.acv.gym.domain.model.Routine


class RoutineMapper : Mapper<RoutineDataModel, Routine> {
    override fun map(input: RoutineDataModel) = with(input) {
        Routine(id, name, image)
    }
}
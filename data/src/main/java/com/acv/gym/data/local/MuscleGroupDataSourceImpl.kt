package com.acv.gym.data.local

import com.acv.gym.data.MuscleGroupDataSource
import com.acv.gym.domain.model.MuscleGroupModel

class MuscleGroupDataSourceImpl : MuscleGroupDataSource {
    override fun getAll(): List<MuscleGroupModel> =
            listOf(MuscleGroupModel("1", "Pecho"),
                    MuscleGroupModel("2", "Espalda"),
                    MuscleGroupModel("3", "Pierna"))
}
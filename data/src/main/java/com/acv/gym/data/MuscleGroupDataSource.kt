package com.acv.gym.data

import com.acv.gym.domain.model.MuscleGroupModel

interface MuscleGroupDataSource {
    fun getAll(): List<MuscleGroupModel>
}
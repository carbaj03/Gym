package com.acv.gym.domain.gateway

import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.model.ExerciseType
import com.acv.gym.domain.model.MuscleGroup
import katz.Either

interface MuscleGroupLocalGateway: BaseGateway<GenericExceptions, MuscleGroup>
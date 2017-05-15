package com.acv.gym.domain.gateway

import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.model.Exercise
import com.acv.gym.domain.usecase.Command


interface ExercisesGateway : BaseGateway<Command, GenericExceptions, Exercise>
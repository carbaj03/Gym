package com.acv.gym.domain.gateway


import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.model.ExerciseType
import com.acv.gym.domain.model.Routine
import katz.Either

interface RoutineLocalGateway: BaseGateway<GenericExceptions, Routine>
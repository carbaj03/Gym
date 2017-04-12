package com.acv.gym.domain.gateway


import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.model.LaunchAppModel
import com.acv.gym.domain.model.RoutineModel
import com.acv.gym.domain.model.SessionExerciseModel
import org.funktionale.either.Disjunction

interface SessionLocalGateway {
    fun obtain(): Disjunction<GenericExceptions, List<SessionExerciseModel>>
    fun persist(): Disjunction<GenericExceptions, List<SessionExerciseModel>>
}

package com.acv.gym.domain.gateway


import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.model.LaunchAppModel
import com.acv.gym.domain.model.RoutineModel
import com.acv.gym.domain.model.SessionExerciseModel
import katz.Either
import org.funktionale.either.Disjunction

interface SessionLocalGateway {
    fun obtain(date : String): Either<GenericExceptions, List<SessionExerciseModel>>
    fun persist(): Either<GenericExceptions, List<SessionExerciseModel>>
}

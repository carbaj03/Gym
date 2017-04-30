package com.acv.gym.domain.gateway


import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.model.LaunchAppModel
import katz.Either
import org.funktionale.either.Disjunction

interface LaunchAppLocalGateway {
    fun obtain(): Either<GenericExceptions, LaunchAppModel>
    fun persist(): Either<GenericExceptions, LaunchAppModel>
}

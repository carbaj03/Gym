package com.acv.gym.domain.gateway


import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.model.LaunchAppModel
import org.funktionale.either.Disjunction

interface LaunchAppLocalGateway {
    fun obtain(): Disjunction<GenericExceptions, LaunchAppModel>
    fun persist(): Disjunction<GenericExceptions, LaunchAppModel>
}

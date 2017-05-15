package com.acv.gym.domain.gateway

import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.model.Exercise
import com.acv.gym.domain.model.Model
import com.acv.gym.domain.usecase.Command


interface GenericGateway<O: Model> : BaseGateway<Command, GenericExceptions, O>
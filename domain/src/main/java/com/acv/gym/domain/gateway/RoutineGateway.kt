package com.acv.gym.domain.gateway


import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.model.Routine
import com.acv.gym.domain.usecase.Command

interface RoutineGateway : BaseGateway<Command, GenericExceptions, Routine>
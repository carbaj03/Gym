package com.acv.gym.domain.gateway


import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.model.SessionExercise
import com.acv.gym.domain.usecase.Command

interface SessionGateway : BaseGateway<Command, GenericExceptions, SessionExercise>
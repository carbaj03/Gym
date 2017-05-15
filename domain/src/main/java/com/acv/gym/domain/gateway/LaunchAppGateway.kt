package com.acv.gym.domain.gateway


import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.model.ExerciseType
import com.acv.gym.domain.model.LaunchApp
import katz.Either

interface LaunchAppGateway : BaseGateway<GenericExceptions, LaunchApp>
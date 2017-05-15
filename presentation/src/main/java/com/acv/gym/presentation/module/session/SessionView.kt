package com.acv.gym.presentation.module.session

import com.acv.gym.domain.model.SessionExercise
import com.acv.gym.presentation.View
import com.acv.gym.presentation.ViewError
import com.acv.gym.presentation.ViewShow

interface SessionView : View , ViewShow<SessionExercise>, ViewError

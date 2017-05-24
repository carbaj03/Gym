package com.acv.gym.domain.usecase.exercise

import com.acv.gym.domain.usecase.Command
import java.util.*
import com.acv.gym.domain.commons.extension.*

data class ExerciseCommand(
        val id: String
) : Command
package com.acv.gym.presentation.module.exercise.type

import com.acv.gym.domain.model.ExerciseType
import com.acv.gym.presentation.View
import com.acv.gym.presentation.ViewError
import com.acv.gym.presentation.ViewShow

interface ExerciseTypeView : View, ViewShow<ExerciseType>, ViewError

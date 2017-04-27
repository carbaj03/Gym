package com.acv.gym.domain.model

/**
 * Created by alejandro on 10/04/17.
 */

data class SessionExerciseModel(val id : String,
                                val exercise : String,
                                val weight : Float,
                                val reps : Int,
                                val session : String): Model

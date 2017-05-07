package com.acv.gym.domain.model

/**
 * Created by alejandro on 10/04/17.
 */

data class SessionExercise(val id : String,
                           val exercise : String,
                           val sets: List<SessionSet>,
                           val session : String): Model

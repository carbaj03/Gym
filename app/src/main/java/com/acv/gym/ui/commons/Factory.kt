package com.acv.gym.ui.commons

import android.view.View
import com.acv.gym.R
import com.acv.gym.module.exercise.ExercisesViewHolder
import com.acv.gym.module.session.SessionViewHolder

/**
 * Created by alejandro on 17/05/17.
 */
object Factory {
    fun create(res: Int, view: View) = when (res) {
        R.layout.item_session -> SessionViewHolder(view)
        else -> ExercisesViewHolder(view)
    }
}
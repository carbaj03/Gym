package com.acv.gym.module.exercise

import android.view.View
import android.widget.TextView
import com.acv.gym.R
import com.acv.gym.domain.model.Exercise
import com.acv.gym.ui.commons.ViewHolder
import org.jetbrains.anko.find

class ExercisesViewHolder(view: View) : ViewHolder<Exercise>(view) {

    var name = view.find<TextView>(R.id.tvName)

    override fun bind(exercise: Exercise) {
        name.text = exercise.name
    }
}

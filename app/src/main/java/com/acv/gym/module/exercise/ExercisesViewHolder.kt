package com.acv.gym.module.exercise

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.acv.gym.R
import com.acv.gym.domain.model.Exercise
import org.jetbrains.anko.find

class ExercisesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    var name = view.find<TextView>(R.id.tvName)

    fun bind(exercise: Exercise) {
        name.text = exercise.name
    }
}

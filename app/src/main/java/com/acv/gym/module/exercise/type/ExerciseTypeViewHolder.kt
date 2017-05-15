package com.acv.gym.module.exercise.type

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.acv.gym.R
import com.acv.gym.domain.model.ExerciseType
import com.acv.gym.domain.model.MuscleGroup
import org.jetbrains.anko.find

class ExerciseTypeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    var name = view.find<TextView>(R.id.tvName)

    fun bind(exerciseType: ExerciseType) {
        name.text = exerciseType.name
    }
}

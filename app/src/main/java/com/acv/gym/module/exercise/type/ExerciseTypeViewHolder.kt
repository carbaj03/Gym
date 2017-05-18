package com.acv.gym.module.exercise.type

import android.view.View
import android.widget.TextView
import com.acv.gym.R
import com.acv.gym.domain.model.ExerciseType
import com.acv.gym.ui.commons.ViewHolder
import org.jetbrains.anko.find

class ExerciseTypeViewHolder(view: View) : ViewHolder<ExerciseType>(view) {

    var name = view.find<TextView>(R.id.tvName)

    override fun bind(exerciseType: ExerciseType) {
        name.text = exerciseType.name
    }
}

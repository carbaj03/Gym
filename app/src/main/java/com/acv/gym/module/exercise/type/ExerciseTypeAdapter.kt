package com.acv.gym.module.exercise.type

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.acv.gym.R
import com.acv.gym.commons.extension.inflate
import com.acv.gym.domain.model.ExerciseType

class ExerciseTypeAdapter(
        val exerciseTypes: List<ExerciseType>,
        val listener: (ExerciseType) -> Unit
) : RecyclerView.Adapter<ExerciseTypeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ExerciseTypeViewHolder(parent.inflate(R.layout.item_exercise_type))

    override fun onBindViewHolder(holder: ExerciseTypeViewHolder, position: Int) = with(holder) {
        bind(exerciseTypes[position])
        itemView.setOnClickListener { listener(exerciseTypes[position]) }
    }

    override fun getItemCount() = exerciseTypes.size
}

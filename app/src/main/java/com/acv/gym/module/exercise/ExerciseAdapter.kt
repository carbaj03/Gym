package com.acv.gym.module.exercise

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.acv.gym.R
import com.acv.gym.commons.extension.inflate
import com.acv.gym.domain.model.Exercise

class ExerciseAdapter(
        val exercises: List<Exercise>,
        val listener: (Exercise) -> Unit
) : RecyclerView.Adapter<ExercisesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ExercisesViewHolder(parent inflate R.layout.item_exercise)

    override fun onBindViewHolder(holder: ExercisesViewHolder, position: Int) = with(holder) {
        bind(exercises[position])
        itemView.setOnClickListener { listener(exercises[position]) }
    }

    override fun getItemCount() = exercises.size
}

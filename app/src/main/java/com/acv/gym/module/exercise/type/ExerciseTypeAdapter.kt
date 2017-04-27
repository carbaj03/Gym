package com.acv.gym.module.exercise.type

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.acv.gym.R
import com.acv.gym.commons.extension.inflate
import com.acv.gym.domain.model.ExerciseTypeModel
import com.acv.gym.domain.model.MuscleGroupModel
import com.acv.gym.domain.model.SessionExerciseModel
import com.acv.gym.module.muscle.group.MuscleGroupViewHolder
import com.acv.gym.module.session.SessionViewHolder

class ExerciseTypeAdapter(
        val exerciseTypes: List<ExerciseTypeModel>,
        val listener: (ExerciseTypeModel) -> Unit)
    : RecyclerView.Adapter<ExerciseTypeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ExerciseTypeViewHolder(parent.inflate(R.layout.item_session))

    override fun onBindViewHolder(holder: ExerciseTypeViewHolder, position: Int) = with(holder) {
        bind(exerciseTypes[position])
        itemView.setOnClickListener { listener(exerciseTypes[position]) }
    }

    override fun getItemCount() = exerciseTypes.size
}

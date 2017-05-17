package com.acv.gym.module.muscle.group

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.acv.gym.R
import com.acv.gym.commons.extension.inflate
import com.acv.gym.domain.model.MuscleGroup

class MuscleGroupAdapter(
        val muscleGroups: List<MuscleGroup>,
        val listener: (MuscleGroup) -> Unit
) : RecyclerView.Adapter<MuscleGroupViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            MuscleGroupViewHolder(parent.inflate(R.layout.item_muscle_group))

    override fun onBindViewHolder(holder: MuscleGroupViewHolder, position: Int) = with(holder) {
        bind(muscleGroups[position])
        itemView.setOnClickListener { listener(muscleGroups[position]) }
    }

    override fun getItemCount() = muscleGroups.size
}

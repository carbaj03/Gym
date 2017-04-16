package com.acv.gym.module.muscle.group

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.acv.gym.R
import com.acv.gym.commons.extension.inflate
import com.acv.gym.domain.model.MuscleGroupModel
import com.acv.gym.domain.model.SessionExerciseModel
import com.acv.gym.module.session.SessionViewHolder

class MuscleGroupAdapter(val muscleGroups: List<MuscleGroupModel>,
                         val listener: (MuscleGroupModel) -> Unit) :
        RecyclerView.Adapter<MuscleGroupViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            MuscleGroupViewHolder(parent.inflate(R.layout.item_session))

    override fun onBindViewHolder(holder: MuscleGroupViewHolder, position: Int) = with(holder) {
        bind(muscleGroups[position])
        itemView.setOnClickListener { listener(muscleGroups[position]) }
    }

    override fun getItemCount() = muscleGroups.size
}

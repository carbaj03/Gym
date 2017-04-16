package com.acv.gym.module.muscle.group

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.acv.gym.R
import com.acv.gym.domain.model.MuscleGroupModel
import org.jetbrains.anko.find

class MuscleGroupViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    var name = view.find<TextView>(R.id.tvName)

    fun bind(muscleGroup: MuscleGroupModel) {
        name.text = muscleGroup.name
    }
}

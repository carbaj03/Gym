package com.acv.gym.module.muscle.group

import android.view.View
import android.widget.TextView
import com.acv.gym.R
import com.acv.gym.domain.model.MuscleGroup
import com.acv.gym.ui.commons.ViewHolder
import org.jetbrains.anko.find

class MuscleGroupViewHolder(view: View) : ViewHolder<MuscleGroup>(view) {
    var name = view.find<TextView>(R.id.tvName)

    override fun bind(model: MuscleGroup) {
        name.text = model.name
    }
}

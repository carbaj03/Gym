package com.acv.gym.module.routine

import android.view.View
import android.widget.TextView
import com.acv.gym.R
import com.acv.gym.domain.model.Routine
import com.acv.gym.ui.commons.ViewHolder
import org.jetbrains.anko.find

class RoutineViewHolder(view: View) : ViewHolder<Routine>(view) {

    var name = view.find<TextView>(R.id.tvName)

    override fun bind(routineModel: Routine) {
        name.text = routineModel.name
    }
}

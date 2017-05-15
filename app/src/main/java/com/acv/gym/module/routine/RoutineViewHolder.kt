package com.acv.gym.module.routine

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.acv.gym.R
import com.acv.gym.domain.model.Routine
import org.jetbrains.anko.find

class RoutineViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    var name = view.find<TextView>(R.id.tvName)

    fun bind(routineModel: Routine) {
        name.text = routineModel.name
    }
}

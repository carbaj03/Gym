package com.acv.gym.module.routines

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.acv.gym.R
import com.acv.gym.domain.model.RoutineModel
import org.jetbrains.anko.find

class RoutinesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    var name = view.find<TextView>(R.id.tvName)

    fun bind(routineModel: RoutineModel) {
        name.text = routineModel.name
    }
}

package com.acv.gym.module.routines

import android.support.v4.widget.SearchViewCompat
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.acv.gym.R
import com.acv.gym.commons.extension.inflate
import com.acv.gym.domain.model.RoutineModel

class RoutinesAdapter(val routines : List<RoutineModel>, val listener : (RoutineModel) -> Unit)
    : RecyclerView.Adapter<RoutinesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoutinesViewHolder
            = RoutinesViewHolder(parent.inflate(R.layout.item_routine))

    override fun onBindViewHolder(holder: RoutinesViewHolder, position: Int) = with(holder) {
        bind(routines[position])
        itemView.setOnClickListener { listener(routines[position]) }
    }

    override fun getItemCount(): Int = routines.size
}

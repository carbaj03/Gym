package com.acv.gym.module.routine

import android.support.v4.widget.SearchViewCompat
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.acv.gym.R
import com.acv.gym.commons.extension.inflate
import com.acv.gym.domain.model.RoutineModel

class RoutineAdapter(val routines : List<RoutineModel>, val listener : (RoutineModel) -> Unit)
    : RecyclerView.Adapter<RoutineViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoutineViewHolder
            = RoutineViewHolder(parent.inflate(R.layout.item_routine))

    override fun onBindViewHolder(holder: RoutineViewHolder, position: Int) = with(holder) {
        bind(routines[position])
        itemView.setOnClickListener { listener(routines[position]) }
    }

    override fun getItemCount(): Int = routines.size
}

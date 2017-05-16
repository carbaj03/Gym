package com.acv.gym.module.routine

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.acv.gym.R
import com.acv.gym.commons.extension.inflate
import com.acv.gym.domain.model.Routine

class RoutineAdapter(
        val routines: List<Routine>,
        val listener: (Routine) -> Unit
) : RecyclerView.Adapter<RoutineViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = RoutineViewHolder(parent.inflate(R.layout.item_routine))

    override fun onBindViewHolder(holder: RoutineViewHolder, position: Int) = with(holder) {
        bind(routines[position])
        itemView.setOnClickListener { listener(routines[position]) }
    }

    override fun getItemCount() = routines.size
}

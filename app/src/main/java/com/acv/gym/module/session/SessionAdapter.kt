package com.acv.gym.module.session

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.acv.gym.R
import com.acv.gym.commons.extension.inflate
import com.acv.gym.domain.model.SessionExercise

class SessionAdapter(val routines: List<SessionExercise>, val listener: (SessionExercise) -> Unit) :
        RecyclerView.Adapter<SessionViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            SessionViewHolder(parent.inflate(R.layout.item_session))

    override fun onBindViewHolder(holder: SessionViewHolder, position: Int) = with(holder) {
        bind(routines[position])
        itemView.setOnClickListener { listener(routines[position]) }
    }

    override fun getItemCount() = routines.size
}

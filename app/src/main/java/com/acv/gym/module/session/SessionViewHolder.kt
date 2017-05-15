package com.acv.gym.module.session

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.acv.gym.R
import com.acv.gym.domain.model.SessionExercise
import org.jetbrains.anko.find

class SessionViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    var name = view.find<TextView>(R.id.tvName)

    fun bind(session: SessionExercise) {
        name.text = session.exercise
    }
}

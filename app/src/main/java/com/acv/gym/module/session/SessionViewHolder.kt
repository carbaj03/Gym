package com.acv.gym.module.session

import android.view.View
import android.widget.TextView
import com.acv.gym.R
import com.acv.gym.domain.model.SessionExercise
import com.acv.gym.ui.commons.ViewHolder
import org.jetbrains.anko.find

class SessionViewHolder(view: View) : ViewHolder<SessionExercise>(view) {
    var name = view.find<TextView>(R.id.tvName)

    override fun bind(session: SessionExercise) {
        name.text = session.exercise
    }
}

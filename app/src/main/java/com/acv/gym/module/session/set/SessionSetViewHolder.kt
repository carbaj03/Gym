package com.acv.gym.module.session.set

import android.view.View
import android.widget.TextView
import com.acv.gym.R
import com.acv.gym.domain.model.SessionExercise
import com.acv.gym.domain.model.SessionSet
import com.acv.gym.ui.commons.ViewHolder
import org.jetbrains.anko.find

class SessionSetViewHolder(view: View) : ViewHolder<SessionSet>(view) {
    var name = view.find<TextView>(R.id.tvName)

    override fun bind(session: SessionSet) {
        name.text = session.reps.toString()
    }
}

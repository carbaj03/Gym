package com.acv.gym.module.session

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import com.acv.gym.R
import com.acv.gym.domain.model.SessionExercise
import com.acv.gym.presentation.model.SessionExerciseVM
import com.acv.gym.ui.commons.VHS
import org.jetbrains.anko.find

sealed class Visivility(val value: Int) {
    object Visible : Visivility(View.VISIBLE)
    object Gone : Visivility(View.GONE)
    object Invisible : Visivility(View.INVISIBLE)
}

class SessionViewHolder(view: View) : VHS<SessionExerciseVM>(view) {
    var name = view.find<TextView>(R.id.tvName)
    var chkItem = view.find<CheckBox>(R.id.chkItem)

    override fun bind(session: SessionExerciseVM, checked: Boolean, visivility: Visivility) {
        name.text = session.exercise.value
        chkItem.isChecked = checked
        chkItem.visibility = visivility.value
    }
}
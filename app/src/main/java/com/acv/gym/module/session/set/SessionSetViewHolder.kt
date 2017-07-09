package com.acv.gym.module.session.set

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import com.acv.gym.R
import com.acv.gym.module.session.Visivility
import com.acv.gym.presentation.model.SessionSetVM
import com.acv.gym.ui.commons.VHS
import org.jetbrains.anko.find

class SessionSetViewHolder(view: View) : VHS<SessionSetVM>(view) {
    var name = view.find<TextView>(R.id.tvName)
    var chkItem = view.find<CheckBox>(R.id.chkItem)

    override fun bind(model: SessionSetVM, checked: Boolean, visivility: Visivility) {
        name.text = model.name
        chkItem.isChecked = checked
        chkItem.visibility = visivility.value
    }
}

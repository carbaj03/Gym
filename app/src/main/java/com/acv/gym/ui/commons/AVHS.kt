package com.acv.gym.ui.commons

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.acv.gym.commons.extension.inflate
import com.acv.gym.domain.model.exercise.ExerciseType
import com.acv.gym.module.exercise.type.ExerciseTypeViewHolder
import com.acv.gym.module.session.SessionViewHolder
import com.acv.gym.module.session.Visivility
import com.acv.gym.presentation.model.SessionExerciseVM
import com.acv.gym.presentation.model.ViewModel

typealias SessionAdapter = AVHS<SessionViewHolder, SessionExerciseVM>
typealias ExerciseTypeAdapter = AVH<ExerciseTypeViewHolder, ExerciseType>

abstract class VHS<in M : ViewModel>(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun bind(model: M, checked: Boolean, visivility: Visivility)
}

open class AVHS<VH : VHS<M>, M : ViewModel>(
        val items: List<M>,
        var listener: (M, Int) -> Unit,
        val holder: (view: View) -> VH,
        val layout: Int,
        var chk: BooleanArray = BooleanArray(items.size)
) : RecyclerView.Adapter<VH>() {
    var visible: Visivility = Visivility.Invisible

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = holder(parent.inflate(layout))

    override fun onBindViewHolder(holder: VH, position: Int) = with(holder) {
        bind(items[position], chk[position], visible)
        itemView.setOnClickListener { listener(items[position], position) }
    }

    override fun getItemCount() = items.size

    fun enabledDeleteMode() {
        visible = Visivility.Visible
        notifyDataSetChanged()
    }

    fun disabledDeleteMode() {
        visible = Visivility.Invisible
        notifyDataSetChanged()
    }

    fun getSelected() : List<M> =
        items.filterIndexed { index, m -> chk[index] }
}
package com.acv.gym.ui.commons

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.acv.gym.commons.extension.inflate

abstract class ViewHolder<in M>(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun bind(model: M)
}

open class AVH<VH : ViewHolder<M>, M>(
        val items: List<M>,
        val listener: (M) -> Unit,
        val holder: (view: View) -> VH,
        val layout: Int
) : RecyclerView.Adapter<VH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = holder(parent.inflate(layout))

    override fun onBindViewHolder(holder: VH, position: Int) = with(holder) {
        bind(items[position])
        itemView.setOnClickListener { listener(items[position]) }
    }

    override fun getItemCount() = items.size
}
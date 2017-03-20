package com.acv.gym.presentation

import me.panavtec.threaddecoratedview.views.ThreadSpec
import me.panavtec.threaddecoratedview.views.ViewInjector

class ViewInjectorImp(private val threadSpec: ThreadSpec) : GymViewInjector {
    override fun <V> injectView(view: V): V = ViewInjector.inject(view, threadSpec)
    override fun <V> nullObjectPatternView(view: V): V = ViewInjector.nullObjectPatternView(view)
}

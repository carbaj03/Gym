package com.acv.gym.commons.outputs

import android.os.Handler

import me.panavtec.threaddecoratedview.views.ThreadSpec

class MainThreadSpec : ThreadSpec {

    internal var handler = Handler()

    override fun execute(action: Runnable) {
        handler.post(action)
    }
}

package com.acv.gym.module.session

import android.view.Menu
import com.acv.gym.commons.extension.DELETE
import com.acv.gym.commons.extension.DONE

data class MenuDelete(val menu: Menu) {

    fun enabled() {
        menu.findItem(DELETE).isVisible = true
        menu.findItem(DONE).isVisible = false
    }

    fun disabled() {
        menu.findItem(DELETE).isVisible = false
        menu.findItem(DONE).isVisible = true
    }
}
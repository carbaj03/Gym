package com.acv.gym.module.rep

import android.view.Menu
import android.view.MenuItem
import com.acv.gym.R
import com.acv.gym.commons.extension.inject
import com.acv.gym.commons.extension.make
import com.acv.gym.commons.extension.menuNav
import com.acv.gym.presentation.module.rep.RepPresenter
import com.acv.gym.presentation.module.rep.RepView
import com.acv.gym.ui.BaseActivity

class RepActivity : BaseActivity<RepView, RepPresenter>(), RepView {
    override fun setupComponent() = inject()

    override fun getLayout() = R.layout.activity_rep

    override fun onCreateOptionsMenu(menu: Menu) = menuInflater.make(R.menu.done, menu)

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.done -> menuNav<RepActivity>()
        else -> super.onOptionsItemSelected(item)
    }
}
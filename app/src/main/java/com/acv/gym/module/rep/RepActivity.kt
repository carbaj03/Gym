package com.acv.gym.module.rep

import android.view.Menu
import android.view.MenuItem
import com.acv.gym.R
import com.acv.gym.commons.extension.*
import com.acv.gym.presentation.module.rep.RepPresenter
import com.acv.gym.presentation.module.rep.RepView
import com.acv.gym.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_rep.*
import org.jetbrains.anko.onClick

class RepActivity : BaseActivity<RepView, RepPresenter>(), RepView {
    override fun setupComponent() = inject()

    override fun getLayout() = R.layout.activity_rep

    override fun createView() {
        setTitle(R.string.rep_title)
        sbReps.listener { tvReps.text = it.toString() }
        fab.onClick { navBack() }
    }

    override fun onCreateOptionsMenu(menu: Menu) = menuInflater.make(R.menu.done, menu)

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.done -> menuNav<RepActivity>()
        else -> super.onOptionsItemSelected(item)
    }
}
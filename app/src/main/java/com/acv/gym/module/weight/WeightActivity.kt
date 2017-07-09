package com.acv.gym.module.weight

import android.view.Menu
import android.view.MenuItem
import com.acv.gym.R
import com.acv.gym.commons.extension.*
import com.acv.gym.module.rep.RepActivity
import com.acv.gym.presentation.module.weight.WeightPresenter
import com.acv.gym.presentation.module.weight.WeightView
import com.acv.gym.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_weight.*
import kotlinx.android.synthetic.main.fragment_weight.*


class WeightActivity : BaseActivity<WeightView, WeightPresenter>() {
    override fun onCreate() {
        setTitle(R.string.title_weight)
        sbWeight.listener { tvWeight.text = it.toString() }
    }

    override fun getLayout() = R.layout.activity_weight

    override fun onCreateOptionsMenu(menu: Menu) = menuInflater.make(R.menu.done, menu)

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        DONE -> menuNav<RepActivity>()
        else -> super.onOptionsItemSelected(item)
    }
}
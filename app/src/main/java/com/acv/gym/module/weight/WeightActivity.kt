package com.acv.gym.module.weight

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SeekBar
import com.acv.gym.R
import com.acv.gym.commons.extension.inject
import com.acv.gym.commons.extension.make
import com.acv.gym.commons.extension.menuNav
import com.acv.gym.module.rep.RepActivity
import com.acv.gym.presentation.module.weight.WeightPresenter
import com.acv.gym.presentation.module.weight.WeightView
import com.acv.gym.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_weight.*


class WeightActivity : BaseActivity<WeightView, WeightPresenter>(), WeightView {
    override fun setupComponent() = inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sbWeight.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                tvWeight.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // Just an empty method
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Another empty method
            }
        })
    }

    override fun getLayout() = R.layout.activity_weight

    override fun onCreateOptionsMenu(menu: Menu) = menuInflater.make(R.menu.done, menu)

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.done -> menuNav<RepActivity>()
        else -> super.onOptionsItemSelected(item)
    }
}
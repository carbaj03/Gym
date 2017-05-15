package com.acv.gym.commons.listener

import android.widget.SeekBar


class SeekBarListener(val f: (Int) -> Unit) : SeekBar.OnSeekBarChangeListener {
    override fun onStartTrackingTouch(seekBar: SeekBar?) {}
    override fun onStopTrackingTouch(seeBar: SeekBar?) {}
    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, p2: Boolean) { f(progress) }
}
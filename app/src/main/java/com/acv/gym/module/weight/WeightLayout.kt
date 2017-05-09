package com.acv.gym.module.weight

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import com.acv.gym.R
import com.acv.gym.ui.ActivityAnkoComponent
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.toolbar

class WeightLayout : ActivityAnkoComponent<WeightActivity> {

    lateinit override var toolbar: Toolbar
    lateinit var weight: TextView
    lateinit var seekBar: SeekBar

    override fun createView(ui: AnkoContext<WeightActivity>) = with(ui) {
        relativeLayout {


            toolbar = toolbar(R.style.ThemeOverlay_AppCompat_Dark_ActionBar)
                    .lparams(width = matchParent) {
                        topMargin = dimen(R.dimen.statusbar_height)
                    }

            listCard = cardView {
                radius = dip(2).toFloat()
                cardElevation = dip(5).toFloat()

                trackList = recyclerView()

            }.lparams {
                below(image)
                horizontalMargin = dip(8)
                topMargin = dimen(R.dimen.album_breaking_edge_height)
                bottomMargin = dip(-5)
            }
        }
    }

}
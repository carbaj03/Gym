package com.acv.gym.module.rep

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.acv.gym.R
import com.acv.gym.commons.extension.*
import com.acv.gym.presentation.module.rep.RepPresenter
import com.acv.gym.presentation.module.rep.RepView
import com.acv.gym.ui.BaseFragment
import kotlinx.android.synthetic.main.activity_rep.*
import kotlinx.android.synthetic.main.fragment_rep.*
import org.jetbrains.anko.onClick

class RepFragment : BaseFragment<RepView, RepPresenter>(), RepView {
    override fun setupComponent() = inject()

    override fun getLayout() = R.layout.fragment_rep

    override fun onCreate() {
        setHasOptionsMenu(true)
        activity.setTitle(R.string.rep_title)
        sbReps.listener { tvReps.text = it.toString() }
        fab?.onClick { navBack() }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.make(R.menu.done, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.done -> navMenu(RepFragment())
        else -> super.onOptionsItemSelected(item)
    }
}
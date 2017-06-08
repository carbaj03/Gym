package com.acv.gym.module.rep

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.acv.gym.R
import com.acv.gym.commons.extension.*
import com.acv.gym.module.session.RepNav
import com.acv.gym.presentation.module.rep.RepPresenter
import com.acv.gym.presentation.module.rep.RepView
import com.acv.gym.ui.BaseFragment
import com.acv.gym.ui.done
import kotlinx.android.synthetic.main.fragment_rep.*

class RepFragment : BaseFragment<RepView, RepPresenter>(), RepView {
    override fun setupComponent() = inject()

    override fun getLayout() = R.layout.fragment_rep

    override fun onCreate() {
        setHasOptionsMenu(true)
        setToolbar(R.string.rep_title)
        sbReps.listener { tvReps.text = it.toString() }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.make(R.menu.done, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.done -> Action { done(RepNav(sbReps.progress)) }
        else -> super.onOptionsItemSelected(item)
    }

    fun value() = RepNav(sbReps.progress)
}
package com.acv.gym.module.weight

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.acv.gym.R
import com.acv.gym.commons.extension.*
import com.acv.gym.domain.model.Weight
import com.acv.gym.module.rep.RepFragment
import com.acv.gym.module.session.NewSessionActivity
import com.acv.gym.module.session.RepNav
import com.acv.gym.module.session.WeightNav
import com.acv.gym.presentation.module.weight.WeightPresenter
import com.acv.gym.presentation.module.weight.WeightView
import com.acv.gym.ui.BaseFragment
import com.acv.gym.ui.done
import kotlinx.android.synthetic.main.fragment_rep.*
import kotlinx.android.synthetic.main.fragment_weight.*

class WeightFragment : BaseFragment<WeightView, WeightPresenter>(), WeightView {
    override fun setupComponent() = inject()

    override fun getLayout() = R.layout.fragment_weight

    override fun onCreate() {
        setHasOptionsMenu(true)
        activity.setTitle(R.string.title_weight)
        sbWeight.listener { tvWeight.text = it.toString() }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.make(R.menu.done, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.done -> Action { done(WeightNav(sbWeight.progress.toFloat())) }
        else -> super.onOptionsItemSelected(item)
    }
}
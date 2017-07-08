package com.acv.gym.module.session.set

import android.view.MenuItem
import android.widget.Toast
import com.acv.gym.R
import com.acv.gym.commons.extension.*
import com.acv.gym.domain.usecase.Id
import com.acv.gym.presentation.model.SessionSetVM
import com.acv.gym.presentation.module.session.set.SessionSetPresenter
import com.acv.gym.presentation.module.session.set.SessionSetView
import com.acv.gym.ui.BaseFragment
import com.acv.gym.ui.commons.AVHS
import kotlinx.android.synthetic.main.fragment_list.*

class SessionSetFragment : BaseFragment<SessionSetView, SessionSetPresenter>(), SessionSetView {
    override fun setupComponent() = inject()

    override fun getLayout() = R.layout.fragment_list

    override fun onCreate() {
        setToolbar(R.string.session_title)
        presenter.loadSessionSet(getArgId())
    }

    override fun show(data: List<SessionSetVM>) = with(rvItems) {
        layoutManager = gridLayoutManager()
        adapter = AVHS(
                items = data,
                listener = { sessionSet, _ -> presenter.checkSessionSet(sessionSet) },
                holder = ::SessionSetViewHolder,
                layout = R.layout.item_session)
    }

    override fun showClick(id: Id) = loadStack<SessionSetActivity>(listOf(extra to id))

    override fun showServerError() = Toast.makeText(activity, "Error Fragment", Toast.LENGTH_LONG).show()

    override fun showNetworkError() = Toast.makeText(activity, "error Fragment", Toast.LENGTH_LONG).show()

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        HOME -> navBack()
        else -> super.onOptionsItemSelected(item)
    }
}

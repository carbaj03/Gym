package com.acv.gym.module.session

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import com.acv.gym.R
import com.acv.gym.commons.extension.*
import com.acv.gym.commons.listener.OnItemTouchListener
import com.acv.gym.domain.model.SessionExercise
import com.acv.gym.domain.usecase.Id
import com.acv.gym.module.session.set.SessionSetActivity
import com.acv.gym.presentation.model.SessionExerciseVM
import com.acv.gym.presentation.module.session.SessionPresenter
import com.acv.gym.presentation.module.session.SessionView
import com.acv.gym.ui.BaseFragment
import com.acv.gym.ui.commons.SessionAdapter
import kotlinx.android.synthetic.main.fragment_list.*

class SessionFragment : BaseFragment<SessionView, SessionPresenter>(), SessionView {
    lateinit var sessionAdapter: SessionAdapter
    lateinit var menu: Menu

    override fun setupComponent() = inject()

    override fun getLayout() = R.layout.fragment_list

    override fun onCreate() {
        setToolbar(R.string.session_title)
        presenter.loadSessions(getArgId())
    }

    override fun refresh() = presenter.loadSessions(getArgId())

    override fun show(sessionExercise: List<SessionExerciseVM>) = with(rvItems) {
        layoutManager = gridLayoutManager()
        sessionAdapter = SessionAdapter(
                items = sessionExercise,
                listener = { session, _ -> presenter.checkExercise(session) },
                holder = ::SessionViewHolder,
                layout = R.layout.item_session)
        adapter = sessionAdapter
        addOnItemTouchListener(OnItemTouchListener(activity, this) { presenter.changeMode() })
    }

    override fun onCreateOptionsMenu(m: Menu, inflater: MenuInflater) {
        inflater.make(R.menu.session, m)
        menu = m
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        HOME -> Action { presenter.back() }
        DONE -> Action { presenter.loadSessions(getArgId()) }
        DELETE -> Action { presenter.delete() }
        else -> super.onOptionsItemSelected(item)
    }

    override fun showClick(id: Id) = loadStack<SessionSetActivity>(listOf(extra to id))

    override fun showServerError() = Toast.makeText(activity, "Error Fragment", Toast.LENGTH_LONG).show()

    override fun showNetworkError() = Toast.makeText(activity, "error Fragment", Toast.LENGTH_LONG).show()

    override fun enabledDeleteMode() = with(sessionAdapter) {
        enabledDeleteMode()
        listener = { session, position ->
            presenter.sessionSelected(session)
            chk[position] = !chk[position]
            notifyItemChanged(position)
        }
        menu.findItem(DELETE).isVisible = true
        menu.findItem(DONE).isVisible = false
        setToolbarIcon(R.drawable.ic_close_black_24dp, R.color.accent)
    }

    override fun disabledDeleteMode() = with(sessionAdapter) {
        disabledDeleteMode()
        listener = { session, _ -> presenter.checkExercise(session) }
        menu.findItem(DELETE).isVisible = false
        menu.findItem(DONE).isVisible = true
        setToolbarIcon()
    }

    override fun goBack() = navBack()
}

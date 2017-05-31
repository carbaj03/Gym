package com.acv.gym.module.session

import android.view.Menu
import android.view.MenuItem
import com.acv.gym.R
import com.acv.gym.commons.extension.*
import com.acv.gym.domain.model.SessionExercise
import com.acv.gym.domain.model.SessionSet
import com.acv.gym.domain.usecase.Id
import com.acv.gym.domain.usecase.SessionCommand
import com.acv.gym.module.muscle.group.MuscleGroupActivity
import com.acv.gym.module.rep.RepActivity
import com.acv.gym.module.session.set.SessionSetActivity
import com.acv.gym.presentation.module.session.SessionPresenter
import com.acv.gym.presentation.module.session.SessionView
import com.acv.gym.ui.BaseActivity
import com.acv.gym.ui.commons.AVH
import katz.Option
import kotlinx.android.synthetic.main.activity_session.*
import kotlinx.android.synthetic.main.fragment_list.*
import org.jetbrains.anko.onClick
import org.jetbrains.anko.toast

class SessionActivity : BaseActivity<SessionView, SessionPresenter>(), SessionView {
    override fun setupComponent() = inject()

    override fun getLayout() = R.layout.activity_session

    override fun onCreate() {
        setTitle(R.string.session_title)
        fab.onClick { navStack<NewSessionActivity>(listOf("id" to Id("1"))) }
        loadFra<SessionFragment>(listOf("id" to getExtra()))
    }

    override fun show(sessionExercise: List<SessionExercise>) = with(rvItems) {
        layoutManager = gridLayoutManager()
        adapter = AVH(
                items = sessionExercise,
                listener = { presenter.checkExercise(it) },
                holder = ::SessionViewHolder,
                layout = R.layout.item_session)
    }

    override fun onCreateOptionsMenu(menu: Menu) = menuInflater.make(R.menu.done, menu)

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.done -> {
            presenter.loadSessions(getId())
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    override fun showServerError() = toast("Error")

    override fun showNetworkError() = toast("Error")

    override fun showClick(id: Id) = load<SessionSetActivity>(listOf("id" to id))
}

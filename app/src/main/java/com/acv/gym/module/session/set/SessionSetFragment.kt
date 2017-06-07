package com.acv.gym.module.session.set

import android.view.MenuItem
import android.widget.Toast
import com.acv.gym.R
import com.acv.gym.commons.extension.*
import com.acv.gym.domain.model.SessionExercise
import com.acv.gym.domain.model.SessionSet
import com.acv.gym.domain.usecase.Id
import com.acv.gym.module.exercise.type.ExerciseTypeFragment
import com.acv.gym.module.muscle.group.MuscleGroupActivity
import com.acv.gym.module.muscle.group.MuscleGroupFragment
import com.acv.gym.module.session.SessionViewHolder
import com.acv.gym.module.session.set.SessionSetActivity
import com.acv.gym.presentation.module.session.SessionPresenter
import com.acv.gym.presentation.module.session.SessionView
import com.acv.gym.presentation.module.session.set.SessionSetPresenter
import com.acv.gym.presentation.module.session.set.SessionSetView
import com.acv.gym.ui.BaseActivity
import com.acv.gym.ui.BaseFragment
import com.acv.gym.ui.commons.AVH
import katz.Option
import kotlinx.android.synthetic.main.activity_session.*
import kotlinx.android.synthetic.main.fragment_list.*
import org.jetbrains.anko.onClick
import org.jetbrains.anko.support.v4.toast
import org.jetbrains.anko.toast

class SessionSetFragment : BaseFragment<SessionSetView, SessionSetPresenter>(), SessionSetView {
    override fun setupComponent() = inject()

    override fun getLayout() = R.layout.fragment_list

    override fun onCreate() {
        setToolbar(R.string.session_title)
        presenter.loadSessionSet(getArgId())
    }

    override fun show(data: List<SessionSet>) = with(rvItems) {
        layoutManager = gridLayoutManager()
        adapter = AVH(
                items = data,
                listener = { presenter.checkSessionSet(it) },
                holder = ::SessionSetViewHolder,
                layout = R.layout.item_session)
    }

    override fun showClick(id: Id) = loadStack<SessionSetActivity>(listOf("id" to id))

    override fun showServerError() = Toast.makeText(activity, "Error Fragment", Toast.LENGTH_LONG).show()

    override fun showNetworkError() = Toast.makeText(activity, "error Fragment", Toast.LENGTH_LONG).show()

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        android.R.id.home -> navBack()
        else -> super.onOptionsItemSelected(item)
    }
}

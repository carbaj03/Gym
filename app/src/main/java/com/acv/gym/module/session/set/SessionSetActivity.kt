package com.acv.gym.module.session.set

import com.acv.gym.R
import com.acv.gym.commons.extension.*
import com.acv.gym.domain.model.SessionSet
import com.acv.gym.domain.usecase.Id
import com.acv.gym.presentation.module.session.set.SessionSetPresenter
import com.acv.gym.presentation.module.session.set.SessionSetView
import com.acv.gym.ui.BaseActivity
import com.acv.gym.ui.commons.AVH
import kotlinx.android.synthetic.main.fragment_list.*
import org.jetbrains.anko.toast

class SessionSetActivity : BaseActivity<SessionSetView, SessionSetPresenter>(), SessionSetView {
    override fun setupComponent() = inject()

    override fun getLayout() = R.layout.activity_session_set

    override fun onCreate() {
        loadFr<SessionSetFragment>(listOf("id" to getExtra()))
    }

    override fun show(data: List<SessionSet>) = with(rvItems) {
        layoutManager = gridLayoutManager()
        adapter = AVH(
                items = data,
                listener = { presenter.checkSessionSet(it) },
                holder = ::SessionSetViewHolder,
                layout = R.layout.item_session)
    }

    override fun showNetworkError() = toast("Error")

    override fun showServerError() = toast("Error")

    override fun showClick(id: Id) = toast("Click")
}

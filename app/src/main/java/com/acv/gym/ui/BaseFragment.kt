package com.acv.gym.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import com.acv.gym.commons.extension.Action
import com.acv.gym.commons.extension.navBack
import com.acv.gym.presentation.GymView
import com.acv.gym.presentation.Presenter
import javax.inject.Inject

abstract class BaseFragment<out V : GymView, P : Presenter<V>> : Fragment() {
    @Inject lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupComponent()
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ) = inflater.inflate(getLayout(), container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onCreate()
    }

    abstract fun setupComponent()
    abstract protected fun getLayout(): Int
    abstract protected fun onCreate()

    open fun refresh() {}
}
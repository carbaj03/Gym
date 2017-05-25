package com.acv.gym.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.acv.gym.presentation.Presenter
import javax.inject.Inject

abstract class BaseFragment<out V : com.acv.gym.presentation.View, P : Presenter<V>> : Fragment() {
    @Inject lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupComponent()
        onCreate()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(getLayout(), container, false)
    }

    abstract fun setupComponent()
    abstract protected fun getLayout(): Int
    abstract protected fun onCreate()
}
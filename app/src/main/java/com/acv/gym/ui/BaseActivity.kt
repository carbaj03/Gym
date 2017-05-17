package com.acv.gym.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.acv.gym.presentation.Presenter
import com.acv.gym.presentation.View
import kotlinx.android.synthetic.main.toobar.*
import javax.inject.Inject


abstract class BaseActivity<out V : View, P : Presenter<V>> : AppCompatActivity() {
    @Inject lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        setSupportActionBar(toolbar)
        setupComponent()
        createView()
    }

    abstract fun createView()
    abstract fun setupComponent()
    abstract fun getLayout(): Int

    override fun setTitle(title: Int) {
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setTitle("")
        tvTitle.text = getString(title)
    }
}

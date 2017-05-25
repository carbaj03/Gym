package com.acv.gym.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import android.view.MenuItem
import com.acv.gym.commons.extension.navBack
import com.acv.gym.domain.usecase.Id
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
        supportActionBar!!.title = ""
        tvTitle.text = getString(title)
    }

    fun getId() = intent.getSerializableExtra("id") as Id

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        android.R.id.home -> navBack()
        else -> super.onOptionsItemSelected(item)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent) = when (keyCode) {
        KeyEvent.KEYCODE_BACK -> navBack()
        else -> super.onKeyDown(keyCode, event)
    }
}

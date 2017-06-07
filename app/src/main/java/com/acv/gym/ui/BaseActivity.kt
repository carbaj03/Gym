package com.acv.gym.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.acv.gym.module.session.Nav
import com.acv.gym.presentation.Presenter
import com.acv.gym.presentation.GymView
import kotlinx.android.synthetic.main.toobar.*
import javax.inject.Inject


abstract class BaseActivity<out V : GymView, P : Presenter<V>> : AppCompatActivity() {
    @Inject lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        setSupportActionBar(toolbar)
        setupComponent()
        onCreate()
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        onNewIntent()
    }

    abstract fun onCreate()
    abstract fun setupComponent()
    abstract fun getLayout(): Int

    open fun onNewIntent(){}
    open fun done(nav: Nav){}


//    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
//        android.R.id.home -> navBack()
//        else -> super.onOptionsItemSelected(item)
//    }
//
//    override fun onKeyDown(keyCode: Int, event: KeyEvent) = when (keyCode) {
//        KeyEvent.KEYCODE_BACK -> navBack()
//        else -> super.onKeyDown(keyCode, event)
//    }
}


fun <V : GymView, P : Presenter<V>> BaseFragment<V, P>.done(nav: Nav) = (activity as BaseActivity<V, P>).done(nav)
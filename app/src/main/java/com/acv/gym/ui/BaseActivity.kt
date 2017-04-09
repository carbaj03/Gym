package com.acv.gym.ui

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity

import com.acv.gym.ui.navigation.Navigator

import javax.inject.Inject


abstract class BaseActivity : AppCompatActivity() {

    @Inject
    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupActivityComponent()
        setupLayout()
    }

    abstract fun setupActivityComponent()

    fun setupLayout() {
        setContentView(getActivityLayout())
    }

    abstract fun getActivityLayout() : Int

}

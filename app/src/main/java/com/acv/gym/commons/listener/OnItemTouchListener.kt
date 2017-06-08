package com.acv.gym.commons.listener

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.GestureDetector
import android.view.MotionEvent


class OnItemTouchListener(
        context: Context,
        rv: RecyclerView,
        val f: () -> Unit
) : RecyclerView.OnItemTouchListener {
    val gestureDetector: GestureDetector by lazy {
        GestureDetector(context, object : GestureDetector.SimpleOnGestureListener() {
            override fun onSingleTapUp(e: MotionEvent) = true

            override fun onLongPress(e: MotionEvent) {
                val child = rv.findChildViewUnder(e.x, e.y)
                child?.let { f() }
            }
        })
    }

    override fun onTouchEvent(rv: RecyclerView?, e: MotionEvent?) {}

    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {}

    override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
        val child = rv.findChildViewUnder(e.x, e.y)
        child?.let { gestureDetector.onTouchEvent(e) }
        return false
    }
}
package com.acv.gym.ui.customview.spinner


import android.app.ProgressDialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.ColorDrawable
import android.support.v4.content.ContextCompat
import android.widget.ProgressBar

import com.acv.gym.R


class SpinnerLoadingImp(private val context: Context) : SpinnerLoading {
    lateinit private var progressDialog: ProgressDialog
    lateinit private var progressBar: ProgressBar

    init {
        setupSpinnerView()
    }

    private fun setupSpinnerView() {
        progressDialog = ProgressDialog(this.context)
        progressDialog.isIndeterminate = true
        progressDialog.setCancelable(false)
        progressDialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        progressBar = ProgressBar(context)
        progressBar.id = R.id.spinner_progress_bar
        progressBar.isIndeterminate = true
        progressBar.indeterminateDrawable.setColorFilter(
                ContextCompat.getColor(context, R.color.colorAccent), PorterDuff.Mode.SRC_IN)
        progressBar.setBackgroundResource(android.R.color.transparent)
    }

    override fun show() {
        if (!progressDialog.isShowing) {
            progressDialog.show()
            progressDialog.setContentView(progressBar)
        }
    }

    override fun show(listener: SpinnerLoadingListener) {
        progressDialog.setOnShowListener { listener.onFinishAction() }
        this.show()
    }

    override fun dismiss() {
        if (progressDialog.isShowing)
            progressDialog.dismiss()
    }

    override fun dismiss(listener: SpinnerLoadingListener) {
        progressDialog.setOnDismissListener { listener.onFinishAction() }
        this.dismiss()
    }
}

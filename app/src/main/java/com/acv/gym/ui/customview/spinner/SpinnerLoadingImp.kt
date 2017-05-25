package com.acv.gym.ui.customview.spinner


import android.app.ProgressDialog
import android.content.Context
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
        setupProgress()
    }

    private fun setupProgress() = with(ProgressBar(context)) {
        progressBar = this
        id = R.id.spinner_progress_bar
        isIndeterminate = true
        indeterminateDrawable.setColorFilter(
                ContextCompat.getColor(context, R.color.accent), PorterDuff.Mode.SRC_IN)
        setBackgroundResource(android.R.color.transparent)
    }

    private fun setupSpinnerView() = with(ProgressDialog(context)) {
        progressDialog = this
        isIndeterminate = true
        setCancelable(false)
        window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    override fun show() = with(progressDialog) {
        isShowing.let {
            show()
            setContentView(progressBar)
        }
    }

    override fun show(listener: SpinnerLoadingListener) {
        progressDialog.setOnShowListener { listener.onFinishAction() }
        this.show()
    }

    override fun dismiss() = with(progressDialog) { isShowing.let { dismiss() } }

    override fun dismiss(listener: SpinnerLoadingListener) = with(progressDialog) {
        setOnDismissListener { listener.onFinishAction() }
        dismiss()
    }
}

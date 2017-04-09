package com.acv.gym.commons.extension

import android.view.LayoutInflater
import android.view.ViewGroup

fun ViewGroup.inflate(res: Int) = LayoutInflater.from(context).inflate(res, this, false)


package com.acv.gym.domain.commons.extension

import java.text.SimpleDateFormat
import java.util.*


fun Calendar.now(): String = SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(time)
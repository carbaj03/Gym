package com.acv.gym.domain.usecase.session

import com.acv.gym.domain.usecase.Command
import java.util.*
import com.acv.gym.domain.commons.extension.*

data class SessionCommand(val date : String = Calendar.getInstance().now())
    : Command
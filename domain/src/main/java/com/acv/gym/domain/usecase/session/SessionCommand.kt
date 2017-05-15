package com.acv.gym.domain.usecase.session

import com.acv.gym.domain.usecase.Command
import java.util.*
import com.acv.gym.domain.commons.extension.*

/**
 * Created by alejandro on 10/04/17.
 */

data class SessionCommand(val date : String = Calendar.getInstance().now()) : Command
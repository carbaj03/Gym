package com.acv.gym.data.local


import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.gateway.LaunchAppGateway
import com.acv.gym.domain.model.LaunchApp
import com.acv.gym.domain.usecase.Command
import katz.Either

class LaunchAppLocalGateway(private val sharedPreferences: Cache) : LaunchAppGateway {
    companion object {
        val KEY_IS_FIRST_TIME_LAUNCH_APP = "key_is_first_time_launch_app"
    }

    override fun obtain(command: Command): Either<GenericExceptions, List<LaunchApp>> {
        try {
            return Either.Right(listOf(LaunchApp(sharedPreferences.get(KEY_IS_FIRST_TIME_LAUNCH_APP, true))))
        } catch (ex: Exception) {
            return Either.Left(GenericExceptions.ServerError())
        }
    }

    override fun persist(): Either<GenericExceptions, List<LaunchApp>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
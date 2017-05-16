package com.acv.gym.data.local


import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.GenericGateway
import com.acv.gym.domain.LaunchAppGateway
import com.acv.gym.domain.model.LaunchApp
import com.acv.gym.domain.usecase.Command
import katz.Either
import katz.Option

class LaunchAppLocalGateway(
        private val sharedPreferences: Cache
) : LaunchAppGateway {
    companion object {
        val KEY_IS_FIRST_TIME_LAUNCH_APP = "key_is_first_time_launch_app"
    }

    override fun obtain(command: Option<Command>): Either<GenericExceptions, List<LaunchApp>> {
        try {
            return Either.Right(listOf(LaunchApp(sharedPreferences.get(KEY_IS_FIRST_TIME_LAUNCH_APP, true))))
        } catch (ex: Exception) {
            return Either.Left(GenericExceptions.ServerError())
        }
    }

    override fun persist(list: List<LaunchApp>): Either<GenericExceptions, List<LaunchApp>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
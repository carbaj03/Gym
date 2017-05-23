package com.acv.gym.data


import com.acv.gym.data.db.cache.Cache
import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.LaunchAppGateway
import com.acv.gym.domain.model.LaunchApp
import com.acv.gym.domain.usecase.Command
import katz.Either
import katz.Option

class LaunchAppGateway(
        private val sharedPreferences: Cache
) : LaunchAppGateway {
    companion object {

        val KEY_IS_FIRST_TIME_LAUNCH_APP = "key_is_first_time_launch_app"
    }

    override fun obtain(command: Option<Command>) =
            try {
                Either.Right(listOf(LaunchApp(sharedPreferences.get(KEY_IS_FIRST_TIME_LAUNCH_APP, true))))
            } catch (ex: Exception) {
                Either.Left(GenericExceptions.ServerError())
            }


    override fun persist(list: List<Command>): Either<GenericExceptions, List<LaunchApp>> {
        TODO("not implemented")
    }

}
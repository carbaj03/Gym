package com.acv.gym.data.local


import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.gateway.LaunchAppLocalGateway
import com.acv.gym.domain.model.LaunchAppModel
import katz.Either

class LaunchAppLocalGatewayImpl(private val sharedPreferences: Cache) : LaunchAppLocalGateway {
    companion object {
        val KEY_IS_FIRST_TIME_LAUNCH_APP = "key_is_first_time_launch_app"
    }

    override fun obtain(): Either<GenericExceptions, LaunchAppModel> {
        try {
            return Either.Right(LaunchAppModel(sharedPreferences.get(KEY_IS_FIRST_TIME_LAUNCH_APP, true)))
        } catch (ex: Exception) {
            return Either.Left(GenericExceptions.ServerError())
        }
    }

    override fun persist(): Either<GenericExceptions, LaunchAppModel> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
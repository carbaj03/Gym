package com.acv.gym.data.local


import com.acv.gym.data.local.Cache
import com.acv.gym.domain.GenericExceptions
import com.acv.gym.domain.gateway.LaunchAppLocalGateway
import com.acv.gym.domain.model.LaunchAppModel
import org.funktionale.either.Disjunction

class LaunchAppLocalGatewayImpl(private val sharedPreferences: Cache) : LaunchAppLocalGateway {
    companion object {
        val KEY_IS_FIRST_TIME_LAUNCH_APP = "key_is_first_time_launch_app"
    }

    override fun obtainLaunchApp(): Disjunction<GenericExceptions, LaunchAppModel> {
        try {
            return Disjunction.right(LaunchAppModel(sharedPreferences.get(KEY_IS_FIRST_TIME_LAUNCH_APP, true)))
        } catch (ex: Exception) {
            return Disjunction.left(GenericExceptions.ServerError())
        }
    }

    override fun persistLaunchApp(): Disjunction<GenericExceptions, LaunchAppModel> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
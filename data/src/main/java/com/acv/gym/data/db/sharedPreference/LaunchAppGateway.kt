package com.acv.gym.data.db.sharedPreference


import com.acv.gym.data.db.cache.Cache
import com.acv.gym.domain.GenericError
import com.acv.gym.domain.SharedPreference
import com.acv.gym.domain.model.LaunchApp
import com.acv.gym.domain.usecase.Command
import katz.Either
import katz.Option

class LaunchAppGateway(
        private val sharedPreferences: Cache
) : SharedPreference {
    companion object {
        val KEY_IS_FIRST_TIME_LAUNCH_APP = "key_is_first_time_launch_app"
    }

    override fun getLaunchApp() =
            try {
                Either.Right(listOf(LaunchApp(sharedPreferences.get(KEY_IS_FIRST_TIME_LAUNCH_APP, true))))
            } catch (ex: Exception) {
                Either.Left(GenericError.ServerError())
            }
}
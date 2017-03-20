package com.acv.gym.module.splash

import com.acv.gym.R
import com.acv.gym.di.EspressoDaggerMockRule
import com.acv.gym.framework.AcceptanceTest
import org.junit.Rule
import org.junit.Test

class SplashActivityTest : AcceptanceTest<SplashActivity>(SplashActivity::class.java) {


    @Rule @JvmField
    var rule = EspressoDaggerMockRule()


    @Test
    fun shouldSayHelloWorld() {
        checkThat.viewContainsText(R.id.logoApp, R.string.app_name)
    }
}

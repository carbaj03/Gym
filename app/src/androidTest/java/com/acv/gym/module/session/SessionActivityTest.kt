package com.acv.gym.module.session

import android.content.Intent
import com.acv.gym.framework.AcceptanceTest
import com.acv.gym.presentation.module.session.SessionPresenter
import com.acv.gym.presentation.module.session.SessionView
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import org.junit.Test
import org.mockito.Matchers
import org.mockito.Mockito

/**
 * Created by alejandro on 10/04/17.
 */
class SessionActivityTest : AcceptanceTest<SessionActivity>(SessionActivity::class.java) {

    var presenter: SessionPresenter = mock()

    @Test
    fun shouldLoadSessionWhenCreateView() {
        Mockito.doNothing().`when`<SessionPresenter>(presenter).attachView(Matchers.any<SessionView>())
//        Mockito.doNothing().`when`<SessionPresenter>(presenter).onFinishSplash()

        testRule.launchActivity(Intent())

        verify(presenter, times(1)).loadSessions(any())
    }
}
package com.acv.gym.presentation.module.weight

import com.nhaarman.mockito_kotlin.mock
import org.junit.Before

class WeightPresenterTest {

    lateinit var presenter: WeightPresenter
    val view: WeightView = mock()

    @Before
    fun setUp() {
        presenter = WeightPresenter(view)
    }
}
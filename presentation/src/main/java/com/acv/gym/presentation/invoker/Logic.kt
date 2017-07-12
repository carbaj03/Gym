package com.acv.gym.presentation.invoker


import com.acv.gym.domain.GenericError
import com.acv.gym.domain.service.Request
import com.acv.gym.domain.service.Service
import kategory.Option

interface ServiceInvoker {
    fun <I : Request, E : GenericError, R> execute(service: Logic<I, E, R>)
}

open class Logic<I : Request, E : GenericError, R>(
        val service: Service<I, R, E>,
        val params: Option<I> = Option.None,
        val result: (R) -> Unit,
        val error: (E) -> Unit
) {
    fun execute(invoker: ServiceInvoker) = invoker.execute(this)
}

infix fun <I : Request, E : GenericError, R> ServiceInvoker.invoke(service: Logic<I, E, R>) =
        service.execute(this)

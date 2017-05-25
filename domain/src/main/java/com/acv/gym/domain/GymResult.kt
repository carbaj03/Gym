package com.acv.gym.domain

import katz.Either

typealias GymResult<T> = Either<GenericError, T>

sealed class GenericError {
    class NetworkError : GenericError()
    class ServerError : GenericError()
}
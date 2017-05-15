package com.acv.gym.domain

sealed class GenericExceptions {
    class NetworkError : GenericExceptions()
    class ServerError : GenericExceptions()
}
package com.acv.gym.data.policy

sealed class Policy {
    class Chache : Policy()
    class Local : Policy()
    class Network : Policy()
}

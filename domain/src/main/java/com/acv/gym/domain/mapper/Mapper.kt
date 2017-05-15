package com.acv.gym.domain.mapper

interface Mapper<in M, out P>{
    fun map(input: M): P
}

//package com.acv.gym.data
//
//import com.acv.gym.data.model.DataModel
//import com.acv.gym.domain.GenericExceptions
//import com.acv.gym.domain.mapper.Mapper
//import com.acv.gym.domain.model.Model
//import org.funktionale.either.Disjunction
//
//
//class Gateway<R : DataModel, out T : Model>(val dataSource: DataSource<R>,
//                                            val mapper: Mapper<R, T>) {
//    fun obtain(): Disjunction<GenericExceptions, List<T>> {
//        try {
//            return Disjunction.right(dataSource.getAll().map { mapper.map(it) })
//        } catch (ex: Exception) {
//            return Disjunction.left(GenericExceptions.ServerError())
//        }
//    }
//
//    fun persist(): Disjunction<GenericExceptions, List<R>> {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//}
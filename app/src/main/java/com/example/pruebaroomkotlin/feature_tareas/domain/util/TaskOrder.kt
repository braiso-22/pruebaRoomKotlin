package com.example.pruebaroomkotlin.feature_tareas.domain.util

sealed class TaskOrder(val orderType: OrderType){
    class Name(orderType: OrderType): TaskOrder(orderType)
    class Timestamp(orderType: OrderType): TaskOrder(orderType)

    fun copy(orderType: OrderType): TaskOrder{
        return when(this) {
            is Name -> Name(orderType)
            is Timestamp -> Timestamp(orderType)
        }
    }
}

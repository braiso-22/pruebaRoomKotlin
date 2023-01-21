package com.example.pruebaroomkotlin.feature_tareas.domain.util

sealed class TaskOrder(val orderType: OrderType){
    class Name(orderType: OrderType): TaskOrder(orderType)
    class Timestamp(orderType: OrderType): TaskOrder(orderType)
}

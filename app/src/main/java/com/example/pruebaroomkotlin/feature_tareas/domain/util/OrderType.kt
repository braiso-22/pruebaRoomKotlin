package com.example.pruebaroomkotlin.feature_tareas.domain.util

sealed class OrderType{
    object Ascending: OrderType()
    object Descending: OrderType()
}

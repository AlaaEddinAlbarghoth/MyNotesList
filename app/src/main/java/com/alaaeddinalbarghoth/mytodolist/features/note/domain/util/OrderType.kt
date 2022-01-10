package com.alaaeddinalbarghoth.mytodolist.features.note.domain.util

sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}

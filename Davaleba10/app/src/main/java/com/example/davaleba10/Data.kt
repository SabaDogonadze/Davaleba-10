package com.example.davaleba10

data class Data(
    val id : Int,
    val icon : Int,
    val text : String,
    val language : String,
    val button: Int,
    val itemType: ItemType = ItemType.NORMAL

)

enum class ItemType{
    NORMAL,
    ADDITIONAL,
    ADDITIONAL2,
}


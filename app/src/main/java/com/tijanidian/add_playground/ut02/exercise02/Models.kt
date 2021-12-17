package com.tijanidian.add_playground.ut02.exercise02

interface LocalModel {
    fun getId(): Int
}

//Si esta data class no extiende de LocalMode no puede funcionar
data class TapaLocalModel(val tapaId: Int, val name:String,val descripcion:String):LocalModel {
    override fun getId(): Int {
        return tapaId
    }
}
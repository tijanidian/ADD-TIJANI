package com.tijanidian.add_playground.ut02.exercise02

class TapaRepository(private val localStorage: LocalStorage<TapaLocalModel>) {

    /**
     * Solo guarda la tapa, no le importa donde se guarde. Almacena una plantilla para alacenar datos
     */
    fun save(tapa:TapaLocalModel){
        localStorage.save(tapa)
    }

    /**
     *
     */
    fun fetch(id:Int):TapaLocalModel?{
        return localStorage.fetch(id.toString())
    }
}
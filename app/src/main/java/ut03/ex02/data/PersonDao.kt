package ut03.ex02.data

import androidx.room.Query
//Es la interfaz para poder acceder a las query de Room por cada funcion hay que indicar la query
interface PersonDao {
    @Query("SELECT * FROM person")
    fun findAll():List<PersonEntity>
}
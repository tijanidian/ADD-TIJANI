package ut03.ex02.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
//Es la interfaz para poder acceder a las query de Room por cada funcion hay que indicar la query
@Dao
interface PersonDao {
    @Query("SELECT * FROM person")
    fun findAll():List<PersonEntity>


    @Insert
    fun insert(personEntity: PersonEntity):Long

    @Insert
    fun insertPersonAndPet(personEntity: PersonEntity, petEntity: PetEntity)
}
package ut03.ex02.data

import androidx.room.*

//Es la interfaz para poder acceder a las query de Room por cada funcion hay que indicar la query
@Dao
interface PersonDao {

    @Query("SELECT * FROM person")
    fun findAll(): List<PersonEntity>

    @Insert
    fun insert(personEntity: PersonEntity): Long

    @Insert
    fun insertPersonAndPet(personEntity: PersonEntity, petEntity: PetEntity)

    @Update
    fun update(personEntity: PersonEntity)
    //Se consultan 2 tablas
    @Transaction
    @Query ("SELECT * FROM person")
    fun getPersonAndPet():List<PersonAndPet>?

}
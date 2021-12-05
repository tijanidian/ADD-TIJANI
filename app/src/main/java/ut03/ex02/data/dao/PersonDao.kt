package ut03.ex02.data.dao

import androidx.room.*
import ut03.ex02.data.*

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


    @Insert
    fun insertPersonAndPetAndCarsAndJobs(
        personEntity: PersonEntity,
        petEntity: PetEntity,
        carEntity: List<CarEntity>,
        jobEntity: List<JobEntity>,
        joinEntity: List<PersonJobEntity>
    )

    @Transaction
    @Query ("SELECT * FROM person")
    fun getPersonAndPetAndCarsAndJobs():List<PersonAndPetAndCarAndJob>?

}
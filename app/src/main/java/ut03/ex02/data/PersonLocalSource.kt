package ut03.ex02.data

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ut03.ex02.app.Ut03Ex02DataBase
import ut03.ex02.domain.PersonModel

class PersonLocalSource(applicationContext: Context) {
    //Creamos la instancia de la bd
    private val db = Ut03Ex02DataBase.getInstance(applicationContext)


    init {
        Thread {
            db.clearAllTables()
        }.start()
        Thread.sleep(1000)
    }

    suspend fun  findAll(): List<PersonModel> = withContext(Dispatchers.IO) {
        val people = db.personDao().getPersonAndPetAndCarsAndJobs()
        //Hacemos un mapper de un modelo a otro
        people?.map { peopleEntity -> peopleEntity.toModel() }?: mutableListOf()
    }

     fun save(personModel: PersonModel) {
        db.personDao().insertPersonAndPet(
            PersonEntity(
                personModel.id!!,
                personModel.name,
                personModel.age
            ), PetEntity(
                personModel.petModel.id,
                personModel.petModel.name,
                personModel.petModel.age,
                personModel.id!!
            )
        )
    }


}

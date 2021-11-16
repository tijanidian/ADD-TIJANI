package ut03.ex02.data

import ut03.ex02.domain.PersonModel
import ut03.ex02.domain.PersonRepository


//Su objetivo es implementar la interfaz que hemos creado en domain
class PersonDataRepository(private val personLocalSource: PersonLocalSource) : PersonRepository {

    override suspend fun savePerson(personModel: PersonModel) {
        personLocalSource.save(personModel)
    }

    override suspend fun fetchAll(): List<PersonModel> = personLocalSource.findAll()


}
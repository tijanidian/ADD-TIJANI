package ut03.ex02.domain

//La forma de acceder a la informacion es atraves de este repositorio
interface PersonRepository {

    //Guardamos una persona
    suspend fun savePerson(personModel: PersonModel)

    suspend fun fetchAll():List<PersonModel>
}
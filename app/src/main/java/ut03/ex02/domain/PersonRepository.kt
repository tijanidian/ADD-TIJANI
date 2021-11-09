package ut03.ex02.domain

//La forma de acceder a la informacion es atraves de este repositorio
interface PersonRepository {

    //Guardamos una persona
    fun savePerson(personModel: PersonModel)

    fun fetchAll():List<PersonModel>
}
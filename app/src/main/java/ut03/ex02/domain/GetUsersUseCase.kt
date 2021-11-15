package ut03.ex02.domain

class GetUsersUseCase(private val repository:PersonRepository) {
    suspend fun execute():List<PersonModel> = repository.fetchAll()
}
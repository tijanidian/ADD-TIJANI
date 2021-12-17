package ut03.ex06.domain

class GetTapasUseCase(private val repository: TapaRepository) {
    suspend fun execute(): Result<List<TapaModel>> {
        return repository.fetchTapas()
    }
}
package ut03.ex06.domain

class GetTapaUseCase(private val repository: TapaRepository) {

    suspend fun execute(tapaId: String): Result<TapaModel?> {
        return repository.fetchTapa(tapaId)
    }
}
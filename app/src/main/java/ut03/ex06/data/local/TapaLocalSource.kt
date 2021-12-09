package ut03.ex06.data.local

import ut03.ex06.domain.TapaModel

interface TapaLocalSource {

    suspend fun findAll(): Result<List<TapaModel>>

    suspend fun saveAll(tapas: Result<List<TapaModel>>)

    suspend fun save(tapa: Result<TapaModel>)

    suspend fun findById(tapaId: String): Result<TapaModel?>
}
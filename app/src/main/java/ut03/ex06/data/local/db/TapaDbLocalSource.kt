package ut03.ex06.data.local.db

import android.content.Context
import ut03.ex06.data.local.TapaLocalSource
import ut03.ex06.domain.TapaModel


class TapaDbLocalSource(applicationContext: Context):TapaLocalSource {
    override suspend fun findAll(): Result<List<TapaModel>> {
        TODO("Not yet implemented")
    }

    override suspend fun saveAll(tapas: Result<List<TapaModel>>) {
        TODO("Not yet implemented")
    }

    override suspend fun save(tapa: Result<TapaModel>) {
        TODO("Not yet implemented")
    }

    override suspend fun findById(tapaId: String): Result<TapaModel?> {
        TODO("Not yet implemented")
    }


}
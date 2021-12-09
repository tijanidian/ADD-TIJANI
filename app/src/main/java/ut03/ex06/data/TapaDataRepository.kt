package ut03.ex06.data

import ut03.ex06.data.local.TapaLocalSource
import ut03.ex06.data.remote.RemoteDataSource
import ut03.ex06.domain.TapaModel
import ut03.ex06.domain.TapaRepository

class TapaDataRepository(
    val remoteSource: RemoteDataSource,
    private val localSource: TapaLocalSource
) : TapaRepository {
    /**
     * Obtiene un listado de tapas.
     * Se consulta en local, si existe un listado de tapas se devuelve, sino, se obtiene de remoto,
     * se guarda en local y se devuelve.
     */
    override suspend fun fetchTapas(): Result<List<TapaModel>> {
        var tapas = localSource.findAll()
        tapas.mapCatching {
            if (it.isEmpty()) {
                tapas = remoteSource.getTapas()
                localSource.saveAll(tapas)

            }
        }
        return tapas
    }

    /**
     * Obtiene un listado de tapas.
     * Se consulta en local, si existe un listado de tapas se devuelve, sino, se obtiene de remoto,
     * se guarda en local y se devuelve.
     */
    override suspend fun fetchTapa(tapaId: String): Result<TapaModel?> {
        var tapa = localSource.findById(tapaId)

        if (tapa.isSuccess) {
            return tapa
        } else if (tapa.isFailure) {
            tapa = remoteSource.getTapa(tapaId)
            localSource.save(tapa)
        }

        return tapa

    }

}
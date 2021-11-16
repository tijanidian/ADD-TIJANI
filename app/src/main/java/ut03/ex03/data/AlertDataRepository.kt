package ut03.ex03.data

import ut03.ex03.data.remote.AlertsRemoteSource
import ut03.ex03.domain.AlertModel
import ut03.ex03.domain.AlertRepository

class AlertDataRepository(private val remoteSource: AlertsRemoteSource):AlertRepository {


    override suspend fun saveAlerts(): List<AlertModel> {
        val alerts=remoteSource.getAlerts()
        TODO("Not yet implemented")
    }

    override suspend fun fechById(alertId: String): AlertModel {
        val alerts=remoteSource.getAlert(alertId)
        TODO("Not yet implemented")
    }

}
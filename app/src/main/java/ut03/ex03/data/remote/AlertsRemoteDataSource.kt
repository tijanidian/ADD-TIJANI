package ut03.ex03.data.remote

import ut03.ex03.app.ApiClient
import ut03.ex03.domain.AlertModel

class AlertsRemoteSource(private  val apiClient: ApiClient) {

  fun getAlerts():List<AlertModel>{
      val alertAPiModel =apiClient.getALerts()
      return alertAPiModel.map { apimodel -> apimodel.toDomainModel() }
  }

    fun getAlert(alertId:String):AlertModel?{
      return apiClient.getAlert(alertId)?.toDomainModel()
    }
}
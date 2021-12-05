package ut03.ex03.domain

interface AlertRepository {

  fun fetchAlerts(): List<AlertModel>
   fun fechById(alertId: String): AlertModel
}
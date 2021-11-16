package ut03.ex03.domain

interface AlertRepository {

  fun saveAlerts(): List<AlertModel>
   fun fechById(alertId: String): AlertModel
}
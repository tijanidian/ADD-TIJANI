package ut03.ex03.domain

class FindAlertUseCase(private val repository: AlertRepository) {
      fun execute(alertId:String):AlertModel= repository.fechById(alertId)
}
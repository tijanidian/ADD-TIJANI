package ut03.ex03.app

import ut03.ex03.data.remote.AlertApiModel

interface ApiClient {
    fun getAlert(alertId:String): AlertApiModel?
    fun getALerts():List<AlertApiModel>
}
package ut03.ex03.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import ut03.ex03.app.RetrofitApiClient
import ut03.ex03.domain.FindAlertUseCase

import ut03.ex03.domain.GetAlertsUseCase

class Ut03Ex03ViewModel(
    private val getAlertsUseCase: GetAlertsUseCase,
    private val findAlertUseCase: FindAlertUseCase
) : ViewModel() {

    fun getAlerts() {
        val apiClient = RetrofitApiClient()
        Thread(Runnable {
            getAlertsUseCase.execute()
            val users = apiClient.getALerts()
            Log.d("@tijani", "$users")
        }).start()


    }
    fun getAlert(alertId: String) {
        val apiClient = RetrofitApiClient()

        Thread(Runnable {
            findAlertUseCase.execute(alertId)
            val user = apiClient.getAlert(alertId)

            Log.d("@tijani,", "$user")
        }).start()

    }

}





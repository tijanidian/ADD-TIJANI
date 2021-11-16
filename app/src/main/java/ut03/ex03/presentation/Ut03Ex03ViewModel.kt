package ut03.ex03.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ut03.ex03.app.RetrofitApiClient
import ut03.ex03.domain.FindAlertUseCase
import ut03.ex03.domain.GetAlertsUseCase

class Ut03Ex03ViewModel(private val getAlertsUseCase: GetAlertsUseCase, private val findAlertUseCase: FindAlertUseCase): ViewModel() {

    fun getAlerts(){
        val apiClient=RetrofitApiClient()
        viewModelScope.launch { Dispatchers.Main
            getAlertsUseCase.execute()
            val users=apiClient.getALerts()
            Log.d("@tijani","$users")
        }

    }

     fun getAlert(alertId:String)=findAlertUseCase.execute(alertId)
}
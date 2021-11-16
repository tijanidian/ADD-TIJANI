package ut03.ex03.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tijanidian.add_playground.R
import ut03.ex03.app.RetrofitApiClient
import ut03.ex03.data.AlertDataRepository
import ut03.ex03.data.remote.AlertsRemoteSource

import ut03.ex03.domain.FindAlertUseCase
import ut03.ex03.domain.GetAlertsUseCase


class Ut03Ex03Activity : AppCompatActivity() {
    private val viewModel: Ut03Ex03ViewModel = Ut03Ex03ViewModel(GetAlertsUseCase(AlertDataRepository(AlertsRemoteSource(RetrofitApiClient()))),
        FindAlertUseCase(AlertDataRepository(AlertsRemoteSource(RetrofitApiClient())))
        )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut03_ex2)
        executeQueryById("2")
        executeQuery()
    }


    fun executeQueryById(alertId: String) {
        viewModel.getAlert(alertId)
    }

    fun executeQuery() {
        viewModel.getAlerts()
    }
}
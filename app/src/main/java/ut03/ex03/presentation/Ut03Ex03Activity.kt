package ut03.ex03.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.tijanidian.add_playground.R
import ut03.ex03.app.RetrofitApiClient
import ut03.ex03.app.Ut03Ex03DataBase
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
        //executeQueryById("2")
        //executeQuery()
        initDb()
    }



    private fun initDb() {
        val apiClient=RetrofitApiClient()
        val db=Room.databaseBuilder(applicationContext,Ut03Ex03DataBase::class.java,"alert-db"
        ).build()

        Thread(Runnable {
            var alerts=db.alertDao().findAll()
            if(alerts==null){
                val alertRemote=apiClient.getALerts()
                Log.d("@tijani1","$alertRemote")
            }else{
                Log.d("@tijani2","$alerts")
            }
        }).start()
    }




/*
    fun executeQueryById(alertId: String) {
            viewModel.getAlert(alertId)

    }

    fun executeQuery() {
            viewModel.getAlerts()

    }
    */

}
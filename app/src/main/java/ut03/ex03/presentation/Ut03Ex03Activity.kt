package ut03.ex03.presentation

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.tijanidian.add_playground.R
import ut03.ex03.app.RetrofitApiClient
import ut03.ex03.app.Ut03Ex03DataBase
import ut03.ex03.data.AlertDataRepository
import ut03.ex03.data.local.LocalDataSource
import ut03.ex03.data.local.entity.AlertEntity
import ut03.ex03.data.remote.AlertsRemoteSource
import ut03.ex03.domain.AlertModel
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
        val db=Room.databaseBuilder(applicationContext,Ut03Ex03DataBase::class.java,"alert-db"
        ).build()

        Thread(Runnable {
            var alerts=db.alertDao().findById("1")

            if(alerts == null){
                db.alertDao().insertAlerts(AlertEntity("1","titulo1","summary1",1,"data","body","source"))
                alerts=db.alertDao().findById("1")

            }else{
             initSharedPref()
            }
        }).start()
    }

    private fun initSharedPref(){
        val apiClient=RetrofitApiClient()
        val alerts=apiClient.getALerts()
        Log.d("@tijani","$alerts")

        val localDataSource=LocalDataSource(this)
        localDataSource.saveAsync("tijani_shared","$alerts")
        val data=localDataSource.readEncrypt("tijani_shared")
        Log.d(TAG, data!!)
        data?.run {
            Log.d(TAG, this)
        }

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
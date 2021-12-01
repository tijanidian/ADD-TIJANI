package com.tijanidian.add_playground.ut03ex04.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tijanidian.add_playground.R
import com.tijanidian.add_playground.ut03ex04.data.local.CustomerLocalDataSource
import com.tijanidian.add_playground.ut03ex04.data.CustomerDataRepository
import com.tijanidian.add_playground.ut03ex04.domain.CustomerModel
import com.tijanidian.add_playground.ut03ex04.domain.customerusecases.SaveCustomerUseCase
class Ut03Ex04Activity : AppCompatActivity() {

    private val viewModel:Ut03Ex04viewModel = Ut03Ex04viewModel(SaveCustomerUseCase(CustomerDataRepository(CustomerLocalDataSource(this))))


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut03_ex04)
        saveCustomer()
    }

/** Código para probar el funcionamiento de la BD
    private fun initDb() {
        val db = Room.databaseBuilder(
            applicationContext,
            Ut03Ex04DataBase::class.java,
            "demo_db"
        ).build()

        Thread(Runnable {
            var customer = db.customerDao().fetchById(1)
            if (customer == null) {
                db.customerDao().insert(CustomerEntity(1, "Tijani", "Dain"))
                db.customerDao().insert(CustomerEntity(2, "Pepe", "Manzana"))
                customer = db.customerDao().fetchById(1)
            }
            Log.d("@dev", "$customer")
        }).start()


    }
    */

    fun saveCustomer(){
        viewModel.saveCustomer(CustomerModel(10,"Manolito","Limón"))
    }

}
package com.tijanidian.add_playground.ut03ex04.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.room.Room
import com.tijanidian.add_playground.R
import com.tijanidian.add_playground.ut03ex04.app.Ut03Ex04DataBase
import com.tijanidian.add_playground.ut03ex04.data.local.entities.CustomerEntity
import com.tijanidian.add_playground.ut03ex04.domain.CustomerRepository
import com.tijanidian.add_playground.ut03ex04.domain.SaveCustomerUseCase

class Ut03Ex04Activity : AppCompatActivity() {

    //private val viewModel:Ut03Ex04viewModel=Ut03Ex04viewModel(SaveCustomerUseCase(CustomerRepository()))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut03_ex04)
        initDb()
    }


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
                customer = db.customerDao().fetchById(1)
            }
            Log.d("@dev", "$customer")
        }).start()


    }
}
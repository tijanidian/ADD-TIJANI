package com.tijanidian.add_playground.ut03ex04.presentation

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import com.tijanidian.add_playground.R
import com.tijanidian.add_playground.ut03ex04.app.Ut03Ex04DataBase
import com.tijanidian.add_playground.ut03ex04.data.local.CustomerLocalDataSource
import com.tijanidian.add_playground.ut03ex04.data.local.db.CustomerDbSource
import com.tijanidian.add_playground.ut03ex04.data.local.db.entities.CustomerEntity
import com.tijanidian.add_playground.ut03ex04.domain.CustomerModel
import com.tijanidian.add_playground.ut03ex04.domain.customerusecases.SaveCustomerUseCase

class Ut03Ex04Activity : AppCompatActivity() {


    private val viewModel: Ut03Ex04viewModel by lazy {
        Ut03Ex04viewModel(SaveCustomerUseCase(CustomerDbSource(applicationContext)))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut03_ex04)
        saveCustomer()
    }


   private fun saveCustomer(){
       viewModel.saveCustomer(CustomerModel(1,"pepe","naranja"))
   }


}
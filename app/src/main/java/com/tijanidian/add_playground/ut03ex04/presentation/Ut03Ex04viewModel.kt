package com.tijanidian.add_playground.ut03ex04.presentation

import androidx.lifecycle.ViewModel
import com.tijanidian.add_playground.ut03ex04.domain.SaveCustomerUseCase

class Ut03Ex04viewModel(private val saveCustomerUseCase: SaveCustomerUseCase):ViewModel() {

    fun saveCustomer(){
        Thread(Runnable {
            saveCustomerUseCase.execute()
        }).start()

    }
}
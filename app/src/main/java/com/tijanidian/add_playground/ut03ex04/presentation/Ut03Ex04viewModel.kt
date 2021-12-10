package com.tijanidian.add_playground.ut03ex04.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tijanidian.add_playground.ut03ex04.domain.CustomerModel
import com.tijanidian.add_playground.ut03ex04.domain.customerusecases.SaveCustomerUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Ut03Ex04viewModel(private val saveCustomerUseCase: SaveCustomerUseCase) : ViewModel() {

    fun saveCustomer(customerModel: CustomerModel) {
        viewModelScope.launch(Dispatchers.IO) {
            var save = saveCustomerUseCase.execute(customerModel)
            Log.d("@tijani", "$save")
        }
    }

}
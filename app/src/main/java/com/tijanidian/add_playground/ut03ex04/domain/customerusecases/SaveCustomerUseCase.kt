package com.tijanidian.add_playground.ut03ex04.domain.customerusecases

import com.tijanidian.add_playground.ut03ex04.data.local.CustomerLocalDataSource
import com.tijanidian.add_playground.ut03ex04.domain.CustomerModel

class SaveCustomerUseCase(private val repository: CustomerLocalDataSource){

    suspend fun execute(customerModel: CustomerModel) = repository.saveCustomer(customerModel)
}
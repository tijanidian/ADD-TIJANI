package com.tijanidian.add_playground.ut03ex04.domain.customerusecases

import com.tijanidian.add_playground.ut03ex04.domain.CustomerModel
import com.tijanidian.add_playground.ut03ex04.domain.CustomerRepository

class FindCustomerUseCase(private val repository: CustomerRepository) {
    suspend fun execute(customerId:Int):CustomerModel=repository.fetchCustomById(customerId)
}
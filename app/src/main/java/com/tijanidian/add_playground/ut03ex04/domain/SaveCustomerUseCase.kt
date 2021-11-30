package com.tijanidian.add_playground.ut03ex04.domain

class SaveCustomerUseCase(private val repository: CustomerRepository) {

    fun execute():CustomerModel = repository.saveCustomer()
}
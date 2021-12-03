package com.tijanidian.add_playground.ut03ex04.data

import com.tijanidian.add_playground.ut03ex04.data.local.CustomerLocalDataSource
import com.tijanidian.add_playground.ut03ex04.domain.CustomerModel
import com.tijanidian.add_playground.ut03ex04.domain.CustomerRepository

class CustomerDataRepository(private val customerLocalDataSource: CustomerLocalDataSource):CustomerRepository {
    override suspend fun saveCustomer(customerModel: CustomerModel) {
       customerLocalDataSource.saveCustomer(customerModel)
    }
}
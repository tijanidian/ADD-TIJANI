package com.tijanidian.add_playground.ut03ex04.data.local

import com.tijanidian.add_playground.ut03ex04.domain.CustomerModel

interface CustomerLocalDataSource {

    suspend fun fetchCustomer(): List<CustomerModel>

    suspend fun fetchByIdCustomert(id: Int): CustomerModel

    suspend fun saveCustomer(customerModel: CustomerModel)

    suspend fun deleCustomer(customerModel: CustomerModel)

    suspend fun updateCustomer(customerModel: CustomerModel)
}
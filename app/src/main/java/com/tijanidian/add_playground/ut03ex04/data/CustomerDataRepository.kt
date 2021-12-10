package com.tijanidian.add_playground.ut03ex04.data

import com.tijanidian.add_playground.ut03ex04.data.local.CustomerLocalDataSource
import com.tijanidian.add_playground.ut03ex04.domain.CustomerModel
import com.tijanidian.add_playground.ut03ex04.domain.CustomerRepository

class CustomerDataRepository(
    private val customerDbSource: CustomerLocalDataSource
) : CustomerRepository {

    override suspend fun saveCustomer(customerModel: CustomerModel) {
        //Si está en local, lo devuelvo, sino voy a red, cojo los datos y los devuelvo.
        customerDbSource.saveCustomer(customerModel)
    }

    override suspend fun fetchCustomers(): List<CustomerModel> {
        var customerDbSource = customerDbSource.fetchCustomer()
        return customerDbSource
    }

    override suspend fun fetchCustomById(idCustomer: Int): CustomerModel {
        var customer = customerDbSource.fetchByIdCustomert(idCustomer)
        return customer
    }


}
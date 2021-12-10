package com.tijanidian.add_playground.ut03ex04.domain

interface CustomerRepository {
    /**
     *  Repositorio con el que accedemos ala información
     */

   suspend fun saveCustomer(customerModel: CustomerModel)

   suspend fun fetchCustomers():List<CustomerModel>

   suspend fun fetchCustomById(idCustomer:Int):CustomerModel

}
package com.tijanidian.add_playground.ut03ex04.data.local.db

import android.content.Context
import com.tijanidian.add_playground.ut03ex04.app.Ut03Ex04DataBase
import com.tijanidian.add_playground.ut03ex04.data.local.CustomerLocalDataSource
import com.tijanidian.add_playground.ut03ex04.data.local.db.entities.CustomerEntity
import com.tijanidian.add_playground.ut03ex04.domain.CustomerModel

class CustomerDbSource(applicationContext: Context) : CustomerLocalDataSource {


    //Instancia de la BD
    private val db = Ut03Ex04DataBase.getInstance(applicationContext)

    init {
        Thread {
            db.clearAllTables()
        }.start()
        Thread.sleep(1000)
    }

    override suspend fun fetchCustomer(): List<CustomerModel> {
        val customer = db.customerDao().fetch()
        return customer.map { customerEntity -> customerEntity.toModel() } ?: mutableListOf()
    }


    override suspend fun fetchByIdCustomert(id: Int): CustomerModel {
        val customer = db.customerDao().fetchById(id)
        return customer.toModel()
    }

    override suspend fun saveCustomer(customerModel: CustomerModel) {
        db.customerDao().insert(CustomerEntity.toEntity(customerModel))
    }

    override suspend fun deleCustomer(customerModel: CustomerModel) {
        db.customerDao().delete(CustomerEntity.toEntity(customerModel))
    }

    override suspend fun updateCustomer(customerModel: CustomerModel) {
        db.customerDao().delete(CustomerEntity.toEntity(customerModel))
    }

}
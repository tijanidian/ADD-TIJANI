package com.tijanidian.add_playground.ut03ex04.data.local

import android.content.Context
import com.tijanidian.add_playground.ut03ex04.app.Ut03Ex04DataBase
import com.tijanidian.add_playground.ut03ex04.data.local.entities.CustomerEntity
import com.tijanidian.add_playground.ut03ex04.domain.CustomerModel
import com.tijanidian.add_playground.ut03ex04.domain.CustomerRepository

class CustomerLocalDataSource(applicationContext: Context):CustomerRepository {

    //Instancia de la BD
    private val db=Ut03Ex04DataBase.getInstance(applicationContext)

    init {
        Thread {
            db.clearAllTables()
        }.start()
        Thread.sleep(1000)
    }

    fun fetchCustomer():List<CustomerModel>{
        val customer=db.customerDao().fetch()
        return customer.map { customerEntity -> customerEntity.toModel()  }?: mutableListOf()
    }


    fun fetchByIdCustomert(id:Int):CustomerModel{
        val customer=db.customerDao().fetchById(id)
        return customer.toModel()
    }

    override suspend fun saveCustomer(customerModel: CustomerModel){
        db.customerDao().insert(CustomerEntity.toEntity(customerModel))
    }

    fun deleCustomer(customerModel: CustomerModel){
        db.customerDao().delete(CustomerEntity.toEntity(customerModel))
    }

    fun updateCustomer(customerModel: CustomerModel){
        db.customerDao().delete(CustomerEntity.toEntity(customerModel))
    }

    /**
     * Product
     */

}
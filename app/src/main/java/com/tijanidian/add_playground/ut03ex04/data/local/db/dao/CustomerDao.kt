package com.tijanidian.add_playground.ut03ex04.data.local.db.dao

import androidx.room.*
import com.tijanidian.add_playground.ut03ex04.data.local.db.entities.CustomerEntity

@Dao
interface CustomerDao {

    @Transaction
    @Query("SELECT * FROM customers")
    fun fetch(): List<CustomerEntity>

    @Transaction
    @Query("SELECT * FROM customers WHERE id = :customerId")
    fun fetchById(customerId: Int): CustomerEntity

    @Insert
    fun insert(customerEntity: CustomerEntity): Long

    @Delete
    fun delete(vararg customerEntity: CustomerEntity)

    @Update
    fun update(vararg customerEntity: CustomerEntity)


}
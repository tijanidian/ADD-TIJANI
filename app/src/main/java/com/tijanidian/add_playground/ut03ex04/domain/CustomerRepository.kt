package com.tijanidian.add_playground.ut03ex04.domain

interface CustomerRepository {
    /**
     *  Repositorio con el que accedemos ala información
     */

    fun saveCustomer():CustomerModel

}
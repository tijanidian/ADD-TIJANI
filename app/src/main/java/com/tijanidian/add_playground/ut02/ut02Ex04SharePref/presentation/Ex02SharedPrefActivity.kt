package com.tijanidian.add_playground.ut02.ut02Ex04SharePref.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import com.tijanidian.add_playground.commons.serializer.GsonSerializer
import com.tijanidian.add_playground.databinding.ActivitySharePreferncesBinding
import com.tijanidian.add_playground.ut02.ut02Ex04SharePref.CustomerModel
import com.tijanidian.add_playground.ut02.ut02Ex04SharePref.InvoiceLinesModel
import com.tijanidian.add_playground.ut02.ut02Ex04SharePref.InvoiceModel
import com.tijanidian.add_playground.ut02.ut02Ex04SharePref.ProductModel
import com.tijanidian.add_playground.ut02.ut02Ex04SharePref.data.CustomerSharPrefLocalSource
import com.tijanidian.add_playground.ut02.ut02Ex04SharePref.data.InvoiceSharPrefLocalSource

class Ex02SharedPrefActivity : AppCompatActivity() {

    private val localSource: CustomerSharPrefLocalSource by lazy {
        CustomerSharPrefLocalSource(this, GsonSerializer(Gson()))
    }
    private val localSourceInvoice: InvoiceSharPrefLocalSource by lazy {
        InvoiceSharPrefLocalSource(this, GsonSerializer(Gson()))
    }


    private val binding: ActivitySharePreferncesBinding by lazy {
        ActivitySharePreferncesBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setUpView()
    }


    private fun setUpView() {
        binding.saveCustomer.setOnClickListener {
            saveCustomer()
        }
        binding.fetch.setOnClickListener {
            fetch()
        }
        binding.fetchById.setOnClickListener {
            findById(6)
        }
        binding.remove.setOnClickListener {
            remove(5)
        }
        binding.update.setOnClickListener {
            upDate()
        }
        binding.saveCustomers.setOnClickListener {
            saveCustomers()
        }

        //Invoice
        binding.saveInvoice.setOnClickListener {
            saveInvoice()
        }

        binding.removeInvoice.setOnClickListener {
            removeInvoice(1)
        }
        binding.fetchInvoice.setOnClickListener {
            fetchInvoice()
        }
        binding.fetchInvoiceId.setOnClickListener {
            fetchInvoiceById(1)
        }

    }

    private fun saveCustomer() {
        val customer = CustomerModel(1, "Pepe", "Pep")
        localSource.save(customer)

    }

    private fun saveCustomers() {
        val customer3 = CustomerModel(5, "Jorge", "Barrio")
        val customer4 = CustomerModel(6, "Xexu", "xexu")
        val customer5 = CustomerModel(7, "Manolito", "Ramos")
        localSource.save(mutableListOf(customer3, customer4, customer5))
    }

    private fun upDate() {
        val customer = CustomerModel(1, "Pepe", "Manzana")
        localSource.update(customer)

    }

    private fun remove(idCustomer: Int) {
        val remove = localSource.remove(idCustomer)
        Log.d("@tijani", "$remove")
    }

    private fun fetch() {
        val fetch = localSource.fetch()
        Log.d("@tijani", "$fetch")

    }

    private fun findById(idCustomer: Int) {
        val find = localSource.findById(idCustomer)
        Log.d("@tijani", "$find")
    }

    private fun saveInvoice() {
        val invoice = InvoiceModel(
            1, "29/11/21", CustomerModel(13, "Ramón", "Calvo"), emptyList(),
        )
        localSourceInvoice.save(invoice)
    }

    private fun removeInvoice(id:Int){
        val remove= localSourceInvoice.remove(id)
        Log.d("@tijani", "$remove")
    }

    private fun fetchInvoice(){
        val fetch= localSourceInvoice.fetch()
        Log.d("@tijani", "$fetch")
    }

    private fun fetchInvoiceById(id:Int){
        val fetch= localSourceInvoice.fetch()
        Log.d("@tijani", "$fetch")
    }
}
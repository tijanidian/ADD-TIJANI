package com.tijanidian.add_playground.ut02.ut02Ex04SharePref.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import com.tijanidian.add_playground.R
import com.tijanidian.add_playground.commons.serializer.GsonSerializer
import com.tijanidian.add_playground.databinding.ActivitySharePreferncesBinding
import com.tijanidian.add_playground.ut02.ut02Ex04SharePref.CustomerModel
import com.tijanidian.add_playground.ut02.ut02Ex04SharePref.data.CustomerSharPrefLocalSource

class Ex02SharedPrefActivity : AppCompatActivity() {

    private val localSource:CustomerSharPrefLocalSource by lazy {
        CustomerSharPrefLocalSource(this,GsonSerializer(Gson()))
    }

    private val binding:ActivitySharePreferncesBinding by lazy {
        ActivitySharePreferncesBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setUpView()
    }


    private fun setUpView(){
        binding.saveCustomer.setOnClickListener {
            saveCustomer()
        }
        binding.fetch.setOnClickListener {
            fetch()
        }
        binding.fetchById.setOnClickListener {
            findById(1)
        }
        binding.remove.setOnClickListener {
            remove(1)
        }
        binding.update.setOnClickListener {
            upDate()
        }

    }
    private fun saveCustomer(){
        val customer=CustomerModel(1,"Pepe","Pep")
        localSource.save(customer)
    }
    private fun saveCustomers(){

    }
    private fun upDate(){
        val customer=CustomerModel(1,"PEPE","PE")
    }
    private fun remove(idCustomer:Int){
        val remove= localSource.remove(idCustomer)
        Log.d("@tijani","$remove")
    }
    private fun fetch(){
        val fetch= localSource.fetch()
        Log.d("@tijani","$fetch")

    }
    private fun findById(idCustomer:Int){
        val find= localSource.findById(1)
        Log.d("@tijani","$find")
    }


}
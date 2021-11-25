package com.tijanidian.add_playground.ut02_share_pref

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.google.gson.JsonSerializer


import com.tijanidian.add_playground.R


class CustomerSharPrefLocalSource(private val context: AppCompatActivity,
                    private val serializer: JsonSerializer<T>
                                  ) {

    private val sharedPref = context.getSharedPreferences(
        context.getString(R.string.file_customer), Context.MODE_PRIVATE
    )

    val masterKey = MasterKey.Builder(context)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()

    private val encryptSharedPref = EncryptedSharedPreferences.create(
        context,
        context.getString(R.string.encrypt_file_key),
        masterKey,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    /**
     * Función que me permite guardar un cliente en un SharedPreferences.
     */
    fun save(customer: CustomerModel) {
        val edit = sharedPref.edit()
        edit.putString("${serializer.to}")
        edit.commit()
    }

    /**
     * Función que me permite guardar un listado de clientes en un SharedPreferences.
     */
    fun save(customers: List<CustomerModel>) {

    }

    /**
     * Función que me permite modificar los datos de un cliente que se encuentran en un fichero.
     * Se puede modificar cualquier dato excepto el id del cliente.
     */
    fun update(customer: CustomerModel) {
        //TODO
    }

    /**
     * Función que me permite eliminar un cliente de un SharedPreferences.
     */
    fun remove(customerId: Int) {

    }

    /**
     * Función que me permite obtener un listado de todos los clientes almacenados en un SharedPreferences.
     */
    fun fetch(): List<CustomerModel> {
        //TODO
        return emptyList()
    }

    fun findById(customerId: Int): CustomerModel? {
        //TODO
        return null
    }
}
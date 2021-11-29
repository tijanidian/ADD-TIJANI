package com.tijanidian.add_playground.ut02.ut02Ex04SharePref.data

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.tijanidian.add_playground.R
import com.tijanidian.add_playground.commons.serializer.JsonSerializer
import com.tijanidian.add_playground.ut02.ut02Ex04SharePref.CustomerModel


class CustomerSharPrefLocalSource(
    private val context: AppCompatActivity,
    private val serializer: JsonSerializer
) {

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
        val edit = encryptSharedPref.edit()
        val idCustomer = customer.id.toString()
        edit.putString(idCustomer, serializer.toJson(customer, CustomerModel::class.java))
        edit.apply()
    }

    /**
     * Función que me permite guardar un listado de clientes en un SharedPreferences.
     */
    fun save(customers: List<CustomerModel>) {
        customers.map { customerModel ->
            save(customerModel)
        }

    }

    /**
     * Función que me permite modificar los datos de un cliente que se encuentran en un fichero.
     * Se puede modificar cualquier dato excepto el id del cliente.
     */
    fun update(customer: CustomerModel) {
        val newCustomers: MutableList<CustomerModel> = mutableListOf()
        val fetchAllCustomer = fetch().toMutableList()

        fetchAllCustomer.forEach {
            newCustomers.add(it)
        }

        val indexPosition = fetchAllCustomer.indexOfFirst { it.id == customer.id }
        fetchAllCustomer[indexPosition] = customer
        val edit = encryptSharedPref.edit()
        val idCustomer = customer.id.toString()
        edit.putString(idCustomer, serializer.toJson(customer, CustomerModel::class.java))
        edit.apply()


    }

    /**
     * Función que me permite eliminar un cliente de un SharedPreferences.
     */
    fun remove(customerId: Int) {
        /*
         val fetchAllCustomer = fetch().toMutableList()
         val customer = fetchAllCustomer.firstOrNull { it.id == customerId }
         fetchAllCustomer.remove(customer)
 */


        encryptSharedPref.edit().remove(customerId.toString()).apply()


    }

    /**
     * Función que me permite obtener un listado de todos los clientes almacenados en un SharedPreferences.
     */
    fun fetch(): List<CustomerModel> {
        val customersList: MutableList<CustomerModel> = mutableListOf()
        encryptSharedPref.all?.values?.forEach {
            customersList.add(serializer.fromJson(it as String, CustomerModel::class.java))
        }
        return customersList
    }

    fun findById(customerId: Int): CustomerModel? {
        val fetchAllCustomer = fetch()
        fetchAllCustomer.forEach {
            if (it.id == customerId) {
                return it
            }
        }

        return null
    }

    companion object {
        val ID: String = CustomerModel::class.java.simpleName
    }

}
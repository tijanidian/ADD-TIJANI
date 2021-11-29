package com.tijanidian.add_playground.ut02.ut02Ex04SharePref.data

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.tijanidian.add_playground.R
import com.tijanidian.add_playground.commons.serializer.JsonSerializer
import com.tijanidian.add_playground.ut02.ut02Ex04SharePref.CustomerModel
import com.tijanidian.add_playground.ut02.ut02Ex04SharePref.InvoiceModel

/**
 * Clase para persistir información en SharedPreferences.
 */
class InvoiceSharPrefLocalSource (private val context: AppCompatActivity,
                                  private val serializer: JsonSerializer
){

    private val sharedPref = context.getSharedPreferences(
        context.getString(R.string.file_invoice), Context.MODE_PRIVATE
    )


    /**
     * Función que me permite guardar un cliente en un sharedprefe.
     */
    fun save(invoice: InvoiceModel) {
        val edit =sharedPref.edit()
        val idInvoice =invoice.id.toString()
        edit.putString(idInvoice, serializer.toJson(invoice, InvoiceModel::class.java))
        edit.apply()
    }

    /**
     * Función que me permite eliminar un cliente de un SharedPreferences.
     */
    fun remove(invoiceId: Int) {
        sharedPref.edit().remove(invoiceId.toString()).apply()
    }

    /**
     * Función que me permite obtener un listado de todos los clientes almacenados en un SharedPreferences.
     */
    fun fetch(): List<InvoiceModel> {
        val customersList: MutableList<InvoiceModel> = mutableListOf()
        sharedPref.all?.values?.forEach {
            customersList.add(serializer.fromJson(it as String, InvoiceModel::class.java))
        }
        return emptyList()
    }

    fun findById(invoiceId: Int): InvoiceModel? {
        val fetchAllCustomer = fetch()
        fetchAllCustomer.forEach {
            if (it.id == invoiceId) {
                return it
            }
        }
        return null
    }
}
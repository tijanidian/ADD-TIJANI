package com.tijanidian.add_playground.ut02.ut02Ex04SharePref.data

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.tijanidian.add_playground.R
import com.tijanidian.add_playground.commons.serializer.JsonSerializer
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

    val masterKey = MasterKey.Builder(context)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()

    private val encryptSharedPref = EncryptedSharedPreferences.create(
        context,
        context.getString(R.string.preference_encrypt_file_invoice_key),
        masterKey,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    /**
     * Función que me permite guardar un cliente en un sharedprefe.
     */
    fun save(invoice: InvoiceModel) {
        //TODO
    }

    /**
     * Función que me permite eliminar un cliente de un SharedPreferences.
     */
    fun remove(invoiceId: Int) {

    }

    /**
     * Función que me permite obtener un listado de todos los clientes almacenados en un SharedPreferences.
     */
    fun fetch(): List<InvoiceModel> {
        //TODO
        return emptyList()
    }

    fun findById(invoiceId: Int): InvoiceModel? {
        //TODO
        return null
    }
}
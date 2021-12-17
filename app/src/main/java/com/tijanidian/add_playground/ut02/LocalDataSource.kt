package com.tijanidian.add_playground.ut02

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.tijanidian.add_playground.R

class LocalDataSource(private val context: AppCompatActivity) {
    //Creamos sharedPref
    private val sharedPref = context.getSharedPreferences(
        context.getString(R.string.file_key), Context.MODE_PRIVATE
    )

    val masterKey = MasterKey.Builder(context)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()

    /**
     * Min sdk 23
     */
    private val encryptSharedPref = EncryptedSharedPreferences.create(
        context,
        context.getString(R.string.encrypt_file_key),
        masterKey,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    //Sirve para guardar de forma sincrona, ¡CUIDADO! puede bloquear el hilo de la IU
    fun saveSync(key: String, data: String) {
        val edit = sharedPref.edit()
        edit?.putString(key, data)
        edit?.apply()
    }

    //Con with nos evitamos tener que repetir los .edit
    fun shortSaveAsync(key: String, data: String) {
        with(sharedPref.edit()) {
            putString(key, data)
            apply()
        }
    }

    //Sirve para guardadar de forma asincrona
    fun saveAsync(key: String, data: String) {
        val edit = sharedPref.edit()
        edit?.putString(key, data)
        edit?.apply()
    }

    fun saveAsyncEncrypt(key: String, data: String) {
        val edit = encryptSharedPref.edit()
        edit?.putString(key, data)
        edit?.apply()
    }


    fun saveSyncEncrypt(key: String, data: String) {
        val edit = encryptSharedPref.edit()
        edit?.putString(key, data)
        edit?.commit()
    }

    fun read(key: String): String? {
        return sharedPref.getString(key, "No devulvo nada")
    }

    fun readEncrypt(key: String): String? {
        return encryptSharedPref.getString(key, "No devulvo nada")
    }


}
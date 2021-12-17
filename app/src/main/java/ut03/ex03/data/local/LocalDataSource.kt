package ut03.ex03.data.local

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.tijanidian.add_playground.R

class LocalDataSource(private val context:AppCompatActivity) {

    private val sharedPref=context.getSharedPreferences("shared_Ut03Ex03",Context.MODE_PRIVATE)

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

    fun saveAsync(key: String, data: String) {
        val edit = sharedPref.edit()
        edit?.putString(key, data)
        edit?.apply()
    }
    fun readEncrypt(key: String): String? {
        return encryptSharedPref.getString(key, "No devulvo nada")
    }
}


package ut02

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.tijanidian.add_playground.R

class SharePreferencesActivity : AppCompatActivity() {
    //Creaemos tag para cada vista para poder verlo por consola
    private val TAG = SharePreferencesActivity::class.java.canonicalName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_prefernces)
        initExample01()
        initExample02()
    }


    private fun initExample01() {
        val localDataSource = LocalDataSource(this)

        localDataSource.saveAsync("tijani", "Acceso a Tijani")
        val data = localDataSource.read("tijani")
        //renombramos ir por str ->
        data?.let { str ->
            Log.d(TAG, str)
        }
    }

    private fun initExample02() {
        val localDataSource = LocalDataSource(this)

        localDataSource.saveAsyncEncrypt("tijaniEncrypt", "Encrypted")
        val data = localDataSource.readEncrypt("tijaniEncrypt")
        Log.d(TAG, data!!)
        data?.run {
            Log.d(TAG, this)
        }
    }


}
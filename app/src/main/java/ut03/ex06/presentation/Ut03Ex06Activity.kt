package ut03.ex06.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import com.tijanidian.add_playground.R
import com.tijanidian.commons.serializer.GsonSerializer
import ut03.ex06.data.local.db.TapaDbLocalSource
import ut03.ex06.data.local.files.TapaFileLocalSource
import ut03.ex06.data.local.xml.TapaXmlLocalSource

class Ut03Ex06Activity : AppCompatActivity() {
    private val TAG = Ut03Ex06Activity::class.java.simpleName

    //probar la aplicación con una fuente de datos de ficheros.
   private val viewModel:Ut03Ex06ViewModel by lazy {
       TapaViewModelFactory.build(TapaFileLocalSource(applicationContext,GsonSerializer(Gson())))
   }

    private val viewModelShared:Ut03Ex06ViewModel by lazy {
        TapaViewModelFactory.build(TapaXmlLocalSource(applicationContext,GsonSerializer(Gson())))
    }

    private val viewModelDb:Ut03Ex06ViewModel by lazy {
        TapaViewModelFactory.build(TapaDbLocalSource(applicationContext))
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut03_ex06)
        init()
    }


    private fun init() {
        loadTapas()
        loadTapa("2")
    }

    private fun loadTapas() {
        viewModel.loadTapas()
    }

    private fun loadTapa(idTapa:String) {
        viewModel.loadTapa(idTapa)
    }

    private fun renderUiTapas(tapasViewState: TapasViewState) {
        tapasViewState.tapaModels?.let {
            Log.d(TAG, "Tapas: $it")
        }
        tapasViewState.failure?.let {
            Log.d(TAG, "Error: $it")
        }
    }

    private fun renderUiTapa(tapaViewState: TapaViewState) {
        tapaViewState.tapaModels?.let {
            Log.d(TAG, "Tapas: $it")
        }
        tapaViewState.failure?.let {
            Log.d(TAG, "Error: $it")
        }
    }
}
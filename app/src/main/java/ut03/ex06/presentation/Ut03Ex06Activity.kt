package ut03.ex06.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import com.tijanidian.add_playground.R
import com.tijanidian.add_playground.databinding.ActivityUt03Ex06Binding
import com.tijanidian.commons.serializer.GsonSerializer
import ut03.ex06.data.local.db.TapaDbLocalSource
import ut03.ex06.data.local.files.TapaFileLocalSource
import ut03.ex06.data.local.xml.TapaXmlLocalSource

class Ut03Ex06Activity : AppCompatActivity() {
    private val TAG = Ut03Ex06Activity::class.java.simpleName

    private val binding: ActivityUt03Ex06Binding by lazy {
        ActivityUt03Ex06Binding.inflate(layoutInflater)
    }

    //probar la aplicación con una fuente de datos de ficheros.
    private val viewModel: Ut03Ex06ViewModel by lazy {
        TapaViewModelFactory.build(TapaFileLocalSource(applicationContext, GsonSerializer(Gson())))
    }

    private val viewModelShared: Ut03Ex06ViewModel by lazy {
        TapaViewModelFactory.build(TapaXmlLocalSource(applicationContext, GsonSerializer(Gson())))
    }

    private val viewModelDb: Ut03Ex06ViewModel by lazy {
        TapaViewModelFactory.build(TapaDbLocalSource(applicationContext))
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initDb()
        initFiles()
        initXml()
    }


    private fun initFiles() {
        loadTapasFile()
        loadTapaFile("2")
    }

    private fun initXml() {
        loadTapasXml()
        loadTapaXml("2")
    }

    private fun initDb() {
        loadTapasDb()
        loadTapaDb("2")
    }


    //Files
    private fun loadTapasFile() {
        binding.actionTapasFile.setOnClickListener {
            viewModel.loadTapas()
        }
    }

    private fun loadTapaFile(idTapa: String) {
        binding.actionTapaFile.setOnClickListener {
            viewModel.loadTapa(idTapa)
        }
    }

    //Xml
    private fun loadTapasXml() {
        binding.actionTapasXml.setOnClickListener {
            viewModel.loadTapas()
        }
    }

    private fun loadTapaXml(idTapa: String) {
        binding.actionTapaXml.setOnClickListener {
            viewModel.loadTapa(idTapa)
        }
    }

    //Db
    private fun loadTapasDb() {
        binding.actionTapasDb.setOnClickListener {
            viewModel.loadTapas()
        }
    }

    private fun loadTapaDb(idTapa: String) {
        binding.actionTapaDb.setOnClickListener {
            viewModel.loadTapa(idTapa)
        }
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
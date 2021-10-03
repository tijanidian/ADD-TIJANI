package com.tijanidian.add_playground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.tijanidian.add_playground.ut_01.DataStorageType
import com.tijanidian.add_playground.ut_01.FileApp
import com.tijanidian.add_playground.ut_01.FilePlayGround
import java.io.File

class MainActivity : AppCompatActivity() {
    //creamos colecion de String de colores, tipo mutable
    val colors: MutableList<String> = mutableListOf()

    //Edir text
    private lateinit var inputNameFile: AppCompatEditText
    private lateinit var inputContentFile: AppCompatEditText

    //Botones
    private lateinit var buttonSave: AppCompatButton
    private lateinit var buttonShowContent: AppCompatButton

    //Textos
    private lateinit var viewerFiles: TextView
    private lateinit var textFileName: TextView
    private lateinit var textFileContent: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Aplicación principal
        setupView()

        /**
         * creamos un nuevo objeto de FilePlayGround
         */
        //val filePlayGround = FilePlayGround(this)


        //val lst = filePlayGround.readFromFile()

        /*
        initColors()

        //visualizar en los los colores

        filePlayGround.saveToFile(colors)
        lst.forEach {
            Log.d("@dev", it)
        }
        */

        /*
        val dataStorageType = DataStorageType(this)
        //dataStorageType.privateFile()
        //dataStorageType.privateFileCache()
        //dataStorageType.privateExternalFile()
        dataStorageType.privateExternalCacheFile()


        //Creamos un objeto de la clase FilePlayground
        val filePlayGround = FilePlayGround(this)
        filePlayGround.createFolder()

       */


    }


    private fun initColors() {
        colors.add("Blue")
        colors.add("Red")
        colors.add("Orange")
        colors.add("Green")
    }


    //Creamos la función principal

    private fun setupView() {
        //Vinculamos la variable que creamos antes con el id del input de nombre
        inputNameFile = findViewById(R.id.input_name_file)

        inputContentFile = findViewById(R.id.input_content_file)

        viewerFiles = findViewById(R.id.viewer_files)
        textFileContent = findViewById(R.id.text_file_content)
        //Boton para guardar la información
        buttonSave = findViewById(R.id.action_save)
        buttonSave.setOnClickListener {
            saveFile()
        }
        //Boton para listar los ficheros
        buttonShowContent = findViewById(R.id.action_show_content)
        buttonShowContent.setOnClickListener {
            showFileContent()
        }


    }


    private fun saveFile() {
        val fileApp = FileApp(this)
        val name = inputNameFile.text.toString()
        val data=inputContentFile.text.toString()
        fileApp.createFile(name, data)



    }

    private fun showFileContent() {
        val fileApp = FileApp(this)

    }

}
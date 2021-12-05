package com.tijanidian.add_playground.ut_01

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.io.File
import kotlin.io.path.Path
import kotlin.io.path.createDirectory
import kotlin.io.path.deleteIfExists
import kotlin.io.path.exists

/**
 *  los dos puntos ":" significa que extendiende de esa clase
 */
class FilePlayGround(private val activity: AppCompatActivity) {
    /**
     * cremos método de kotline, init es la primera función que se ejecuta al instanciar la clase
     */

    init {

        //createFile()
        //writeFile()
        //readFile()
        //appendText()
        //appendTextWithNewLine()
        //readLineByLine()
        //deleteFile()
        //createFolder()
        //createFileInFolder()



    }

    //Método para crear un fichero
    fun createFile() {
        /**
         * variable file inmutable, y usamos la clase File de java
         *
         */
        val file = File(activity.filesDir, "add.txt")
        //Log.d("@dev", activity.filesDir.absolutePath)
    }

    fun writeFile() {

        val file = File(activity.filesDir, "add.txt")
        file.writeText("Hola acceso a Datos")
    }

    fun readFile() {
        val file = File(activity.filesDir, "add.txt")
        val line = file.readText()
        Log.d("@dev", line)
    }

    //Metodo para añadir otra linea
    fun appendText() {
        val file = File(activity.filesDir, "add.txt")
        file.appendText("hola2")
        file.appendText("hola3")
        file.appendText("hola4")
        //probamos por consola
        val line = file.readText()
        Log.d("@dev", line)
    }

    //añadir texto en una nueva linea
    fun appendTextWithNewLine() {
        val file = File(activity.filesDir, "add.txt")
        file.appendText("\n")
        file.appendText("Adios1")
        file.appendText("\n")
        file.appendText("Adios2")
        //probamos por consola
        val line = file.readText()
        Log.d("@dev", line)

    }

    //leer linea por linea

    fun readLineByLine() {
        val file = File(activity.filesDir, "add.txt")
        file.writeText("Linea 1")
        file.appendText("\n")
        file.appendText("Linea 2")
        file.appendText("\n")
        file.appendText("Linea 3")


        //Nos da un String que se almacena en una lista
        val lines: List<String> = file.readLines()
        //recibo String, con la palabra it
        lines.forEach {
            Log.d("@dev", it)
        }

    }

    //Borrar ficheros
    fun deleteFile() {
        val file = File(activity.filesDir, "add.txt")
        //si existe el fichero, se elimina el fichero
        if (file.exists()) {
            file.delete()
        }
    }

    //Guardar la lista de colores en el fichero linea por linea
    fun saveToFile(colors: MutableList<String>) {
        //Seleccionamos el fichero
        val file = File(activity.filesDir, "colors.txt")
        if (file.exists()) {
            file.writeText("")
        }

        colors.forEach {
            file.appendText(it + "\n")
        }
    }

    /**
     * Función que lee un fichero y devuelve los colores
     * en un listado.
     */
    fun readFromFile(): MutableList<String> {
        //Creo array colors que voy a devolver
        val colors = mutableListOf<String>()
        val file = File(activity.filesDir, "colors.txt")
        //Si no existe devulve colors
        if (!file.exists()) {
            return colors
        }
        file.readLines().forEach {
            colors.add(it)
        }

        return colors
    }

    /**
     * Otra forma de leer el fichero
     */
    fun readFromFile2(): MutableList<String> {

        var file = File(activity.filesDir, "colors.txt")

        return if (file.exists()) {
            file.readLines().toMutableList()
        } else {
            mutableListOf()
        }
    }

    /**
     * Función para crear carpetas
     */

    fun createFolder(){
        //Opción1
        val file=File(activity.filesDir,"/docs")
        file.mkdir()

    }

    fun createFileInFolder(){

        val file= File(activity.filesDir.canonicalPath,"/documents/aad.txt")
        //file.writeText("Hola!")

    }




}
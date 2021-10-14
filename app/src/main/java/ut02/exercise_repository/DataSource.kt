package ut02.exercise_repository

import android.content.Context
import com.tijanidian.add_playground.R
import ut02.LocalDataSource


/**
 * Interfaz genérica que define una fuente de datos sin especificar el tipo.
 */
interface DataSource {
    fun save(key: String, model: String)
    fun fetch(key: String): String?
    fun fetchAll(key: String): String?
}

/**
 * Clase que permite almacenar objetos en memoria.
 */
class MemDataSource : DataSource {

    private val memDataStorage: MutableMap<String, String> = mutableMapOf()

    override fun save(key: String, model: String) {
        memDataStorage.put(key, model)
    }

    override fun fetch(key: String): String? {
        return memDataStorage.getValue(key)
    }

    override fun fetchAll(key: String): String? = memDataStorage.get(key)

}

/**
 * Clase que permite almacenar objetos en un fichero SharedPreferences
 */
class SharPrefDataSource : DataSource {

  //Crear un shared preference

    override fun save(key: String, model: String) {
        TODO("Not yet implemented")
    }

    override fun fetch(key: String): String? {
        TODO("Not yet implemented")
    }

    override fun fetchAll(key: String): String? {
        TODO("Not yet implemented")
    }

}
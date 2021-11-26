package com.tijanidian.add_playground.ut02.exercise02

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.tijanidian.add_playground.R
import com.tijanidian.add_playground.commons.Serializer

import java.io.File

//Algo generico que debe extender si o si de LocalModel
interface LocalStorage<T:LocalModel> {
    fun save(model:T)
    fun fetch(id:String):T?
}
//Hay que definir primero la interfaz DataSource
class FileLocalStorage<T:LocalModel>(
    private val activity: AppCompatActivity,
    private val serializer: Serializer<T>
):LocalStorage<T>
{


    private val file= File(activity.filesDir,"aad_ex02.tx")

    override fun save(model: T) {
       file.writeText(serializer.toJson(model))
    }

    override fun fetch(id: String): T {
        val jsonModel:String=file.readText()
        return serializer.fromJson(jsonModel)
    }

}


class MemLocalStorage<T:LocalModel> :LocalStorage<T>{
    //Creamos un listado para guardar los datos
    private val dataStore= mutableListOf<T>()


    override fun save(model: T) {
        dataStore.add(model)
    }

    override fun fetch(id: String): T? {
        //Para recorrer colecciones, es un filtro y obtenemos uno único valor porque es un id
       return dataStore.firstOrNull() { it.getId().toString() == id }

        /*La manera larga
        dataStore.forEach {
            if (it.getId().toString()==id){
                return it
            }
        }
        return  null
    */
    }

}

    class SharPrefDataSource <T:LocalModel>(private val activity: AppCompatActivity,private val serializer:Serializer<T>):LocalStorage<T>{

        private val sharedPref = activity.getSharedPreferences(activity.getString(R.string.preference_file_exercise02),
            Context.MODE_PRIVATE)

        override fun save(model: T) {
            val editor=sharedPref.edit()
            editor?.putString(model.getId().toString(),serializer.toJson(model))
            editor.apply()
        }

        override fun fetch(id: String): T? {
            val jsonModel = sharedPref.getString(id,"{}")
            return if(jsonModel != null){
                serializer.fromJson(jsonModel)
            }else{
                null
            }
        }

    }





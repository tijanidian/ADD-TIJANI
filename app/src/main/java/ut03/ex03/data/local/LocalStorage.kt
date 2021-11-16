package ut03.ex03.data.local

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import commons.Serializer
import ut03.ex03.domain.LocalModel


interface LocalStorage<T:LocalModel> {
    fun save(model:T)
    fun fetch(id:String):T?
}
class SharPrefDataSource<T:LocalModel>(private val activity: AppCompatActivity, private val serializer: Serializer<T>):LocalStorage<T>{

    private val sharedPref=activity.getSharedPreferences("UT03_ex03", Context.MODE_PRIVATE)

    override fun save(model: T) {
        val editor=sharedPref.edit()
        editor?.putString(model.alertId(),serializer.toJson(model))
        editor.apply()
    }

    override fun fetch(id:String): T? {
        val jsonModel=sharedPref.getString(id,"{}")
        return if (jsonModel != null){
            serializer.fromJson(jsonModel)
        }else{
            null
        }
    }

}

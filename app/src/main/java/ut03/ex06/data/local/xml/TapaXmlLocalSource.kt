package ut03.ex06.data.local.xml

import android.content.Context
import com.tijanidian.add_playground.R
import com.tijanidian.commons.serializer.JsonSerializer
import ut03.ex06.data.local.TapaLocalSource
import ut03.ex06.domain.TapaModel

class TapaXmlLocalSource(context: Context, private val serializer: JsonSerializer) :
    TapaLocalSource {

    private val sharPref = context.getSharedPreferences(
        context.getString(R.string.action_sharpref),
        Context.MODE_PRIVATE
    )


    override suspend fun findAll(): Result<List<TapaModel>> {
        val tapaList: MutableList<TapaModel> = mutableListOf()
        sharPref.all?.values?.forEach {
            tapaList.add(serializer.fromJson(it as String, TapaModel::class.java))
        }
        return Result.success(tapaList)
    }

    override suspend fun saveAll(tapas: Result<List<TapaModel>>) {
        val edit = sharPref.edit()
        tapas.mapCatching {
            it.forEach {
                val idTapa = it.id.toString()
                edit?.putString(idTapa, serializer.toJson(it, TapaModel::class.java))
                edit.apply()
            }
        }
    }

    override suspend fun save(tapa: Result<TapaModel>) {
        val edit = sharPref.edit()
        tapa.mapCatching {
            val idTapa = it.id.toString()
            edit?.putString(idTapa, serializer.toJson(it, TapaModel::class.java))
            edit.apply()
        }


    }

    override suspend fun findById(tapaId: String): Result<TapaModel?> {
        return findAll().mapCatching {
            it.firstOrNull() {
                it.id == tapaId
            }
        }
    }


}
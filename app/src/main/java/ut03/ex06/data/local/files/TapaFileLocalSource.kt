package ut03.ex06.data.local.files

import android.content.Context
import com.tijanidian.commons.serializer.JsonSerializer
import ut03.ex06.data.local.TapaLocalSource
import ut03.ex06.domain.Failure
import ut03.ex06.domain.TapaModel
import java.io.File
import java.lang.Exception

class TapaFileLocalSource(val context: Context, private val serializer: JsonSerializer) :
    TapaLocalSource {


    override suspend fun findAll(): Result<List<TapaModel>> {
        val tapas: MutableList<TapaModel> = mutableListOf()
        val file = getFile(TAPAS_FILENAME)
        if (file.isSuccess) {
            file.mapCatching {
                val lines = it.readLines()
                lines.map {
                    val tapaModel = serializer.fromJson(it, TapaModel::class.java)
                    tapas.add(tapaModel)
                }
            }
        }
        return Result.success(tapas)
    }

    override suspend fun saveAll(tapas: Result<List<TapaModel>>) {
        val file = getFile(TAPAS_FILENAME)

        if (file.isSuccess){
            file.mapCatching { file->
                tapas.mapCatching { tapa->
                    tapa.map {
                        file.appendText(serializer.toJson(it,TapaModel::class.java))
                    }
                }
            }
        }
    }

    override suspend fun save(tapa: Result<TapaModel>) {
        val file = getFile(TAPAS_FILENAME)
        if (file.isSuccess) {
            file.mapCatching { file ->
                tapa.mapCatching { tapa ->
                    file.appendText(serializer.toJson(tapa, TapaModel::class.java))
                }
            }
        }
    }

    override suspend fun findById(tapaId: String): Result<TapaModel?> {
       return findAll().mapCatching {
           it.first{tapa->
               tapa.id== tapaId
           }
       }
    }

    private fun getFile(fileName: String): Result<File> {
        val file = File(context.filesDir, fileName)
        return try {
            if (!file.exists()) {
                file.createNewFile()
            }
            Result.success(file)

        } catch (ex: Exception) {
            Result.failure(Failure.FailError)
        }


    }

    companion object {
        const val TAPAS_FILENAME: String = "aad_tapas.txt"
    }

}
package ut03.ex06.domain

interface TapaRepository {

    suspend fun fetchTapas():Result<List<TapaModel>>

    suspend fun fetchTapa(tapaId:String):Result<TapaModel?>

}
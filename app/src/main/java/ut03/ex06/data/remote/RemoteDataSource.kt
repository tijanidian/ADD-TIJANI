package ut03.ex06.data.remote

import ut03.ex06.domain.TapaModel

interface RemoteDataSource{
    fun getTapa(tapaId:String):Result<TapaModel>
    fun getTapas():Result<List<TapaModel>>
}
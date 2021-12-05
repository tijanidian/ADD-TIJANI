package ut03.ex03.app

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import ut03.ex03.data.remote.AlertApiModel

interface ApiEndPoint {
    @GET("alerts")
    fun getAlerts(): Call<ApiResponse<List<AlertApiModel>>>

    @GET("alerts/{alert_id}")
    fun getAlert(@Path("alert_id")alert_id:String):Call<ApiResponse<AlertApiModel>>

}
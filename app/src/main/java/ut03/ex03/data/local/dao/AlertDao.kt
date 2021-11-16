package ut03.ex03.data.local.dao

import androidx.room.Query
import androidx.room.Transaction
import ut03.ex03.data.local.entity.AlertEntity

interface AlertDao {

    @Transaction
    @Query("SELECT * FROM alerts")
    fun findAll():List<AlertEntity>

    @Query("SELECT * FROM alerts WHERE alertId = :alert_id")
    fun findById(alert_id:String):AlertEntity
}
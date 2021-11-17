package ut03.ex03.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "alerts")
data class AlertEntity(
    @PrimaryKey @ColumnInfo(name = "alertId")val alertId:String,
    @ColumnInfo(name="title")val title:String,
    @ColumnInfo(name ="type")val summary:Int,
    @ColumnInfo(name ="summary")val type:String,
    @ColumnInfo(name ="date")val date:String,
    @ColumnInfo(name ="body")val body:String,
    @ColumnInfo(name ="source")val source:String
)
package ut03.ex03.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "alerts")
data class AlertEntity(
    @PrimaryKey @ColumnInfo(name = "alertId")val alertId:String,
    @ColumnInfo(name="title")val title:String,
    @ColumnInfo(name ="summary")val summary:String,
    @ColumnInfo(name ="summary")val type:String,
    @ColumnInfo(name ="summary")val date:String
)
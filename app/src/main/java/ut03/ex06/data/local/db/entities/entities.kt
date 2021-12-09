package ut03.ex06.data.local.db

import androidx.room.*
import ut03.ex06.domain.BarModel
import ut03.ex06.domain.CompetitionModel
import ut03.ex06.domain.TapaModel
import java.util.*


@Entity(tableName = "competition")
data class CompetitionEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "start") val start: Date,
    @ColumnInfo(name = "end") val end: Date,
    @ColumnInfo(name="tapaId") val tapaId:String
) {/*
    fun toModel(tapaEntity: TapaEntity):CompetitionModel{
        return CompetitionModel(
            id,
            start,
            end,
        )
    }
*/


}


@Entity(tableName = "bar")
data class BarEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "address") val address: String
) {
    fun toModel(): BarModel {
        return BarModel(
            id,
            name,
            address
        )
    }

    companion object {
        fun toEntity(bar: BarModel): BarEntity {
            return BarEntity(
                bar.id,
                bar.name,
                bar.address
            )
        }
    }
}


@Entity(tableName = "tapas")
data class TapaEntity(
    @PrimaryKey @ColumnInfo(name = "id") val tapaId: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "price") val price: Double,
    @ColumnInfo(name = "urlMainPhoto") val urlPricePhoto: String,
    @ColumnInfo(name = "barId") val barId: String

) {
    fun toModel(barEntity: BarEntity) = TapaModel(
        tapaId,
        name,
        description,
        price,
        urlPricePhoto,
        barEntity.toModel()
    )

    companion object {
        fun toEntity(tapaModel: TapaModel, barId: String) = TapaEntity(
            tapaModel.id,
            tapaModel.name,
            tapaModel.description,
            tapaModel.price,
            tapaModel.urlMainPhoto,
            barId
        )
    }

}

data class TapaAndBar(
    @Embedded val tapaEntity: TapaEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "id"
    ) val barEntity: BarEntity
) {
    fun toModel() = tapaEntity.toModel(barEntity)
}





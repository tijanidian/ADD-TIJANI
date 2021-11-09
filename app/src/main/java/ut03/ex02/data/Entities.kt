package ut03.ex02.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ut03.ex02.domain.PersonModel

//Para trabajar con Room

@Entity(tableName = "person")
data class PersonEntity (
        @PrimaryKey @ColumnInfo(name="id") val id:Int,
        @ColumnInfo(name="name") val name:String,
        @ColumnInfo(name="age") val age:String,
        ){

        fun toModel():PersonModel=PersonModel(id, name, age = 1,null)
}

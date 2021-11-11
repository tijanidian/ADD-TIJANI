package ut03.ex02.data

import androidx.room.*
import ut03.ex02.domain.PersonModel
import ut03.ex02.domain.PetModel

//Para trabajar con Room

@Entity(tableName = "person")
data class PersonEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "age") val age: Int,
) {

    //Método que permite converti a un modelo de datos mio
    fun toModel(): PersonModel = PersonModel(id, name, age, "", PetModel(1, "perro", 6))
}

@Entity(tableName = "pet")
data class PetEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "age") val age: Int,
    @ColumnInfo(name = "person_id") val personId: Int
)

data class PersonAndPet(
    //Tabla padre
    @Embedded val personEntity: PersonEntity,
    //Cual es el atributo clave y la FK
    @Relation(
        parentColumn = "id",
        entityColumn = "person_id"
    ) val petEntity: PetEntity
) {
    fun toModel() = PersonModel(
        personEntity.id,
        personEntity.name,
        personEntity.age,
        "",
        PetModel(petEntity.id, petEntity.name, 0)
    )
}

/*
data class  PersonAndPetAndCar(
    @Embedded val personEntity: PersonEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "person_id"
    )val petEntity: PetEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = ""
    )

)
*/


package ut03.ex02.data

import androidx.room.*
import ut03.ex02.domain.CarModel
import ut03.ex02.domain.JobModel
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
    fun toModel(
        petEntity: PetEntity,
        carEntities: List<CarEntity>,
        jobEntities: List<JobEntity>
    ): PersonModel = PersonModel(
        id,
        name,
        age,
        "",
        petEntity.toModel(),
        carEntities.map { carEntity -> carEntity.toModel() },
        jobEntities.map { jobEntity -> jobEntity.toModel() }
    )
}


@Entity(tableName = "pet")
data class PetEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "age") val age: Int,
    @ColumnInfo(name = "person_id") val personId: Int
) {
    fun toModel() = PetModel(id, name, age)

    companion object {
        fun toEntity(petModel: PetModel, personId: Int) =
            PetEntity(petModel.id, petModel.name, petModel.age, personId)
    }
}

data class PersonAndPet(
    //Tabla padre
    @Embedded val personEntity: PersonEntity,
    //Cual es el atributo clave y la FK
    @Relation(
        parentColumn = "id",
        entityColumn = "person_id"
    ) val petEntity: PetEntity
)

/**
 * Una persona puede tener de 0 a N coches
 */
@Entity(tableName = "car")
data class CarEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "brand") val brand: String,
    @ColumnInfo(name = "model") val model: String,
    @ColumnInfo(name = "person_id") val personId: Int,
) {
    fun toModel() = CarModel(id, brand, model)

    companion object {
        fun toEntity(carsModel: List<CarModel>, personId: Int) = carsModel.map {
            CarEntity(it.id, it.brand, it.model, personId)
        }
    }
}

/**
 * Una persona puede tener de 1:N coches.
 *
 * Relación 1:N donde Person cede su clave primaria a Car.
 */
data class PersonAndPetAndCar(
    @Embedded val personEntity: PersonEntity,
    @Relation(
        parentColumn = "id", //clave primaria de la entidad Person.
        entityColumn = "person_id" //clave foránea de la entidad Pet.
    ) val petEntity: PetEntity, //Entidad que recibe la clave de otra entidad

    @Relation(
        parentColumn = "id", //clave primaria de la entidad Person.
        entityColumn = "person_id" //clave foránea de la entidad Car.
    ) val carEntities: List<CarEntity>, //Entidad que recibe la clave de otra entidad

)


@Entity(tableName = "job")
data class JobEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "name") val name: String,
) {
    fun toModel() = JobModel(id, name)

    companion object {
        fun toEntity(jobsModel: List<JobModel>) = jobsModel.map {
            JobEntity(it.id, it.name)
        }
    }
}

@Entity(
    tableName = "person_job",
    primaryKeys = ["person_id", "job_id"]
)
data class PersonJobEntity(
    @ColumnInfo(name = "person_id") val personId: Int,
    @ColumnInfo(name = "job_id") val jobId: Int
) {
    companion object {
        fun toEntity(personId: Int, jobIds: List<Int>) =
            jobIds.map { jobId -> PersonJobEntity(personId, jobId) }
    }
}

data class PersonAndPetAndCarAndJob(
    @Embedded val personEntity: PersonEntity, //Entidad Principal

    @Relation(
        parentColumn = "id",
        entityColumn = "person_id"
    ) val petEntity: PetEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "person_id"
    ) val carEntities: List<CarEntity>,


    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(
            value = PersonJobEntity::class,
            parentColumn = "id",
            entityColumn = "job_id"
        )
    ) val jobEntities: List<JobEntity>,

    ) {
    fun toModel() = personEntity.toModel(petEntity, carEntities, jobEntities)
}






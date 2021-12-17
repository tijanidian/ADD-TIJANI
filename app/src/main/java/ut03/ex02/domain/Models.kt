package ut03.ex02.domain

//Se definden todas la funcionalidades de la app
data class PersonModel(
    val id: Int,
    val name: String,
    val age: Int,
    val address: String?,
    //Una persona tiene una mascoda, relación 1 a 1
    val petModel: PetModel,
    val carModel: List<CarModel>,
    val jobModel: List<JobModel>
)

data class PetModel(val id: Int, val name: String, val age: Int)


data class CarModel(val id: Int, val brand: String, val model: String)

data class JobModel(val id: Int, val name: String)


package ut03.ex02.domain
//Se definden todas la funcionalidades de la app
data class PersonModel (val id: Int?=0,
                        val name:String,
                        val age: Int,
                        val address:String?,
                        //Una persona tiene una mascoda, relación 1 a 1
                        val petModel:PetModel
                        )

data class  PetModel(val id:Int, val name: String, val age:Int)


//Hacer petEntity, crar petDao y declarar el Dao en la bd
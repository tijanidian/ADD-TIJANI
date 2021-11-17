package ut03.ex02.data.dao

import androidx.room.Query
import ut03.ex02.data.PersonAndPetAndCar

interface CardDao {
    @Query("SELECT * FROM pet")
    fun findAll():List<PersonAndPetAndCar>
}
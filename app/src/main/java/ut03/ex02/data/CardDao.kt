package ut03.ex02.data

import androidx.room.Query

interface CardDao {
    @Query("SELECT * FROM pet")
    fun findAll():List<PersonAndPetAndCar>
}
package ut03.ex02.data.dao

import androidx.room.Query
import ut03.ex02.data.PersonJobEntity


interface PersonJobDao {
    @Query("SELECT * FROM pet")
    fun findAll():List<PersonJobEntity>
}
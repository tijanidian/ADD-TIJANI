package ut03.ex02.data

import androidx.room.Dao
import androidx.room.Query


class PetDao {
    @Dao
    interface PetDao {
        @Query("SELECT * FROM pet")
        fun findAll():List<PersonEntity>
    }
}
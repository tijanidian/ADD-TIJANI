package ut03.ex02.data.dao

import androidx.room.Dao
import androidx.room.Query
import ut03.ex02.data.PetEntity

@Dao
    interface PetDao {
        @Query("SELECT * FROM pet")
        fun findAll():List<PetEntity>
    }

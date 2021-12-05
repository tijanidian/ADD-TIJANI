package ut03.ex02.data.dao

import androidx.room.Query
import ut03.ex02.data.JobEntity


interface JobDao {
    @Query("SELECT * FROM job")
    fun findAll():List<JobEntity>
}
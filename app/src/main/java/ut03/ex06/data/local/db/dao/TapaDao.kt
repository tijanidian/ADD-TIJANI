package ut03.ex06.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import ut03.ex06.data.local.db.TapaAndBar
import ut03.ex06.data.local.db.TapaEntity

@Dao
interface TapaDao {

    @Insert
    fun insert(tapa: TapaEntity)

    @Transaction
    @Query("SELECT * FROM tapas")
    fun getTapas(): List<TapaAndBar>
    @Transaction
    @Query("SELECT * FROM tapas WHERE id= :tapaId")
    fun getTapa(tapaId: String): TapaAndBar


}
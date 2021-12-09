package ut03.ex06.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ut03.ex06.data.local.db.TapaAndBar

@Dao
interface TapaDao {

    @Insert
    fun insert(tapa: TapaAndBar)

    @Query("SELECT * FROM tapas")
    fun getTapas(): List<TapaAndBar>

    @Query("SELECT * FROM tapas WHERE id= :tapaId")
    fun getTapa(tapaId: String): TapaAndBar


}
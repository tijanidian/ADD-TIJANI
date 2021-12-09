package ut03.ex06.app

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ut03.ex06.data.local.db.BarEntity
import ut03.ex06.data.local.db.TapaEntity
import ut03.ex06.data.local.db.dao.TapaDao


@Database(
    entities = [BarEntity::class,TapaEntity::class],
    version = 1,
    exportSchema = false
)

abstract class Ut03Ex06DataBase : RoomDatabase() {

    abstract fun tapaDap(): TapaDao

    companion object {
        @Volatile
        private var instance: Ut03Ex06DataBase? = null

        fun getInstance(applicationContext: Context): Ut03Ex06DataBase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(applicationContext).also { instance = it }
            }
        }


        private fun buildDatabase(applicationContext: Context): Ut03Ex06DataBase {
            return Room.databaseBuilder(
                applicationContext,
                Ut03Ex06DataBase::class.java,
                "db-ut03-ex04"
            ).build()
        }
    }
}
package ut03.ex03.app

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ut03.ex03.data.local.dao.AlertDao
import ut03.ex03.data.local.entity.AlertEntity


@Database(
    entities = [AlertEntity::class],
    version = 1,
    exportSchema = false
)

abstract class Ut03Ex03DataBase : RoomDatabase() {
    abstract fun alertDao(): AlertDao


    //Singleton
    companion object {
        @Volatile
        private var instance: Ut03Ex03DataBase? = null

        fun getInstance(applicationContext: Context): RoomDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(applicationContext).also { instance = it }
            }
        }

        private fun buildDatabase(applicationContext: Context): Ut03Ex03DataBase {
            return Room.databaseBuilder(
                applicationContext,
                Ut03Ex03DataBase::class.java,
                "db-ut03-ex03"
            ).build()
        }

    }

}
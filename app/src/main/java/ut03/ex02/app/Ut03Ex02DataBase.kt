package ut03.ex02.app

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ut03.ex02.data.PersonDao
import ut03.ex02.data.PersonEntity
import ut03.ex02.data.PetDao
import ut03.ex02.data.PetEntity

//Tiene que ser una clase abstracta con la etiqueta Database e indicar las entidades
@Database(
    entities = [PersonEntity::class, PetEntity::class], version = 1,
    exportSchema = false
)
//Tiene que estender de RoomDataBase
abstract class Ut03Ex02DataBase : RoomDatabase() {

    abstract fun personDao(): PersonDao
    abstract fun petDao(): PetDao

    //Singleton
    companion object {
        @Volatile
        private var instance: Ut03Ex02DataBase? = null

        fun getInstance(applicationContext: Context): Ut03Ex02DataBase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(applicationContext).also { instance = it }
            }
        }

        private fun buildDatabase(applicationContext: Context): Ut03Ex02DataBase {
            return Room.databaseBuilder(
                applicationContext,
                Ut03Ex02DataBase::class.java,
                "db-ut03-ex02"
            ).build()
        }

    }


}
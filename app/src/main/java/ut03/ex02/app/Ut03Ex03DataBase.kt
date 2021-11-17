package ut03.ex02.app

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ut03.ex02.data.*
import ut03.ex02.data.dao.PersonDao
import ut03.ex02.data.dao.PetDao

//Tiene que ser una clase abstracta con la etiqueta Database e indicar las entidades
@Database(
    entities = [PersonEntity::class,
        PetEntity::class,
    CarEntity::class,
    JobEntity::class,
    PersonJobEntity::class

               ], version = 1,
    exportSchema = false
)
//Tiene que estender de RoomDataBase
abstract class Ut03Ex03DataBase : RoomDatabase() {

    abstract fun personDao(): PersonDao
    abstract fun petDao(): PetDao

    //Singleton
    companion object {
        @Volatile
        private var instance: Ut03Ex03DataBase? = null

        fun getInstance(applicationContext: Context): Ut03Ex03DataBase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(applicationContext).also { instance = it }
            }
        }

        private fun buildDatabase(applicationContext: Context): Ut03Ex03DataBase {
            return Room.databaseBuilder(
                applicationContext,
                Ut03Ex03DataBase::class.java,
                "db-ut03-ex02"
            ).build()
        }

    }


}
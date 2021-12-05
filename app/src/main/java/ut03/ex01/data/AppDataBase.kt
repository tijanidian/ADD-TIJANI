package ut03.ex01.data

import androidx.room.Database
import androidx.room.RoomDatabase

//Clase encargada de gestionar todo

@Database(entities = [UserEntity::class],version = 1)
//Al tener un método no implentado,la clase tiene que ser abstracta

abstract class AppDataBase:RoomDatabase() {
    abstract fun userDao(): UserDao

}
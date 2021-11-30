package com.tijanidian.add_playground.ut03ex04.app

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tijanidian.add_playground.ut03ex04.data.local.dao.CustomerDao
import com.tijanidian.add_playground.ut03ex04.data.local.entities.CustomerEntity

@Database(
    entities = [CustomerEntity::class],
    version = 1,
    exportSchema = false
)
abstract class Ut03Ex04DataBase:RoomDatabase() {

    abstract fun customerDao(): CustomerDao

    companion object {
        @Volatile
        private var instance: Ut03Ex04DataBase? = null

        fun getInstance(applicationContext: Context): Ut03Ex04DataBase{
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(applicationContext).also { instance = it }
            }
        }


        private fun buildDatabase(applicationContext: Context): Ut03Ex04DataBase {
            return Room.databaseBuilder(
                applicationContext,
                Ut03Ex04DataBase::class.java,
                "db-ut03-ex04"
            ).build()
        }
    }
}
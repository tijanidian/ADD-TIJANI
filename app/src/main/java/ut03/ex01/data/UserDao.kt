package ut03.ex01.data

import androidx.room.*

// (Dao)Data Acces Object
//Clase con solo funciones, consultas
@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll():List<UserEntity>

    @Query("SELECT * FROM user WHERE id= :id")
    fun findById(id:Int): UserEntity?

    @Query("SELECT * FROM user where id IN(:userIds)")
    fun findAllByIds(userIds:IntArray):List<UserEntity>?

    @Query("SELECT * FROM user where name LIKE :name  AND :username")
    fun findByName(name:String, username:String): UserEntity?


    //Insertar elementos
    @Insert
    fun insert(userEntity: UserEntity)

    //Eliminar objero
    @Delete
    fun delete(userEntity: UserEntity)

    @Update
    fun update(userEntity: UserEntity)

}
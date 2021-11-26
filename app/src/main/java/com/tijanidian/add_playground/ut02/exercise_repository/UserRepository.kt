package com.tijanidian.add_playground.ut02.exercise_repository



import com.google.gson.Gson

/**
 * Ejercicio para ver y practicar el patrón repositorio con dos fuentes de datos:
 *  - Memoria
 *  - SharedPreferences
 */
class UserRepository(
    private val memDataSource: MemDataSource,
    private val sharPrefDataSource: SharPrefDataSource,
    private val serializer: Gson
) {
    private val KEY_USER = "key_user"

    /**
     * Guardo siempre en disco, en fichero shared preferences
     */
    fun saveUsers(users: List<UserModel>) {
        sharPrefDataSource.save(KEY_USER, serializer.toJson(users))
    }
    
/*
    fun fetchUser(id: Int): List<UserModel> {
        var jsonUsers=memDataSource.fetch("$id")

        jsonUsers?.let{strJson ->
            return serializer.fromJson(strJson, Array<UserModel>::class.java).toList()
        }

        return null
    }
*/
    /**
     * Primero se busca en memoria, si hay datos se devuelven. Sino, se recupera de disco, se
     * guarda en memoria y se devuelven los datos.
     */
    fun fetchAllUsers(): List<UserModel>? {
        //Obtengo de memoria, si hay datos los devuelvo sino, continuo el código.
        var jsonUsers = memDataSource.fetchAll(KEY_USER)
        jsonUsers?.let { strJson ->
            return serializer.fromJson(strJson, Array<UserModel>::class.java).toList()
        }

        //Obtengo de disco, si hay datos, los guardo en memoria y devuelvo los datos, sino, continuo
        jsonUsers = sharPrefDataSource.fetchAll(KEY_USER)
        jsonUsers?.let { strJson ->
            val users = serializer.fromJson(strJson, Array<UserModel>::class.java).toList()
            saveUsers(users)
            return users
        }

        //No hay datos en memoria ni en disco.
        return null
    }
}



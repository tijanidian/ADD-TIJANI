package com.tijanidian.add_playground.ut_01

import androidx.appcompat.app.AppCompatActivity
import java.io.File

class DataStorageType (private val activity: AppCompatActivity) {

    /**
     * Android dispone de cuatro formas de guardar la información:
     *  1. Específicos: sólo pueden acceder a los ficheros la propia aplicación.
     *  2. Compartida: los ficheros se pueden compartir con otras aplicaciones.
     *  3. Clave-Valor.
     *  4. Bases de datos.
     *
     */
     fun privateFile(){
        val privateFile= File(activity.filesDir, "private.txt")
        privateFile.writeText("Fichero privado en el directorio de la app")
    }

    /**
     * Fichero específico de la app en el directorio de la caché.
     * Las aplicaciones externas no pueden acceder a estos ficheros.
     * No se necesitan permisos especiales.
     * Los ficheros desaparecen si se desinstala la aplicación.
     */
    fun privateFileCache(){
        val cacheFile = File(activity.cacheDir, "private_cache.txt")
        cacheFile.writeText("Hola!")

    }

    /**
     * Fichero específico de la app en un medio externo.
     * Las aplicaciones externas no pueden acceder a estos ficheros.
     * No se necesitan permisos especiales cuando la app es usada en dispositivos con la versión
     * api 19 (4.4) o posterior.
     * Los ficheros desaparecen si se desinstala la aplicación.
     */
    fun privateExternalFile(){
        val externalFile=File(activity.getExternalFilesDir("path_directory"),"external.txt")
        externalFile.writeText("Privado en un alamacenamiento externo")
    }

    /**
     * Fichero específico de la app de caché en un medio externo.
     * Las aplicaciones externas no pueden acceder a estos ficheros.
     * No se necesitan permisos especiales cuando la app es usada en dispositivos con la versión
     * api 19 (4.4) o posterior.
     * Los ficheros desaparecen si se desinstala la aplicación.
     */
    fun privateExternalCacheFile(){
        val cacheExternalFile=File(activity.externalCacheDir,"cache_external_dir.txt")
        cacheExternalFile.writeText("Hola!")
    }




}
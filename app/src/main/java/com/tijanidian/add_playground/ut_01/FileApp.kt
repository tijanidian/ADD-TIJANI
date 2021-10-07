package com.tijanidian.add_playground.ut_01

import androidx.appcompat.app.AppCompatActivity
import java.io.File

class FileApp(private val activity:AppCompatActivity) {


    fun createFile(name:String,data:String) {
        val file = File(activity.filesDir, name)

        if(file.exists()){
            file.writeText("")
        }
        file.appendText(data)
    }



    fun showFiles(): MutableList<String> {
        val file = File(activity.filesDir, ".")

        return if (file.exists()) {
            file.list().toMutableList()
        } else {
            mutableListOf()
        }


    }

    fun showFilesContent(name: String): MutableList<String>{
        val file = File(activity.filesDir,name )
        return if (file.exists()) {
            file.readLines().toMutableList()
        } else {
            mutableListOf()
        }

    }



    fun deleteFile(name:String){
        val file = File(activity.filesDir, name)

        if(name==file.name){
            file.delete()
        }
    }
}
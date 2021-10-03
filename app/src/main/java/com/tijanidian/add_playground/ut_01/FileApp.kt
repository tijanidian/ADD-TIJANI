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



    fun showFile(name:String){
        val file = File(activity.filesDir, "$name+.txt")

    }
}
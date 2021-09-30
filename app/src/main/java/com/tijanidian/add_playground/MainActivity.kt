package com.tijanidian.add_playground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.tijanidian.add_playground.ut_01.FilePlayGround

class MainActivity : AppCompatActivity() {
    //creamos colecion de String de colores, tipo mutable
    val colors: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        /**
         * creamos un nuevo objeto de FilePlayGround
         */
        val filePlayGround = FilePlayGround(this)

        val lst= filePlayGround.readFromFile()
        //visualizar en los los colores
        initColors()


        filePlayGround.saveToFile(colors)
        lst.forEach {
            Log.d("@dev",it)
        }


    }

    private fun initColors(){
        colors.add("Blue")
        colors.add("Red")
        colors.add("Orange")
        colors.add("Green")
    }


}
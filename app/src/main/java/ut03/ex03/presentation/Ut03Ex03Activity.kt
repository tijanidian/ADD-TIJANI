package ut03.ex03.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.tijanidian.add_playground.R


class Ut03Ex03Activity : AppCompatActivity() {
    private val viewModel:Ut03Ex03ViewModel by viewModels()
    override  fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut03_ex2)
        executeQuery()
    }


    fun executeQuery(){
        viewModel.getAlerts()
    }
}
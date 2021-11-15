package ut03.ex02.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.tijanidian.add_playground.R
import ut03.ex02.data.PersonDataRepository
import ut03.ex02.data.PersonLocalSource
import ut03.ex02.domain.*

class Ut03Ex03Activity : AppCompatActivity() {

    private val viewModel=Ut03Ex03ViewModel()
    private val TAG = Ut03Ex03Activity::class.java.simpleName

    private val repository: PersonRepository by lazy {
        PersonDataRepository(PersonLocalSource(applicationContext))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut03_ex03)
        executeQuery()
    }


    private fun executeQuery() {
        viewModel.getUsers()
    }
}
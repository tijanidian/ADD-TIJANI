package ut03.ex02.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.tijanidian.add_playground.R
import ut03.ex02.data.PersonDataRepository
import ut03.ex02.data.PersonLocalSource
import ut03.ex02.domain.GetUsersUseCase
import ut03.ex02.domain.PersonModel
import ut03.ex02.domain.PersonRepository
import ut03.ex02.domain.PetModel

class Ut03Ex02Activity : AppCompatActivity() {
    private val TAG = Ut03Ex02Activity::class.java.simpleName

    private val viewModel:Ut03Ex02ViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut03_ex03)
        executeQuery()
    }


    private fun executeQuery() {
      viewModel.getUsers()

    }
}
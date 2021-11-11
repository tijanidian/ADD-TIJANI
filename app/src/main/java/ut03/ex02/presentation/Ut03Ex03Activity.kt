package ut03.ex02.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.tijanidian.add_playground.R
import ut03.ex02.data.PersonDataRepository
import ut03.ex02.data.PersonLocalSource
import ut03.ex02.domain.PersonModel
import ut03.ex02.domain.PersonRepository
import ut03.ex02.domain.PetModel

class Ut03Ex03Activity : AppCompatActivity() {
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

        Thread {
            repository.savePerson(PersonModel(1, "name01", 23, "calle uno", PetModel(1, "dog", 5)))
            repository.savePerson(PersonModel(2, "name02", 34, "calle dos", PetModel(2, "cat", 4)))
            val people = repository.fetchAll()
            Log.d(TAG, "$people")

        }.start()
    }
}
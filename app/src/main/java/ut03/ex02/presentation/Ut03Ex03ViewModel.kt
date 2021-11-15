package ut03.ex02.presentation

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ut03.ex02.domain.GetUsersUseCase
import ut03.ex02.domain.PersonModel
import ut03.ex02.domain.PetModel

class Ut03Ex03ViewModel(private val getUsersUseCase: GetUsersUseCase):ViewModel()  {
    //Crear caso de uso y propagar el suspend
    fun getUsers(){
        viewModelScope.launch { Dispatchers.IO
          getUsersUseCase.execute()
        }
    }

}
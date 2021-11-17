package ut03.ex02.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ut03.ex02.domain.GetUsersUseCase
import ut03.ex02.domain.PersonModel
import ut03.ex02.domain.PetModel
import ut03.ex03.domain.GetAlertsUseCase

class Ut03Ex02ViewModel(private val getUsersUseCase: GetUsersUseCase):ViewModel() {

     fun getUsers(){
        viewModelScope.launch { Dispatchers.IO
            getUsersUseCase.execute()
        }
    }


}
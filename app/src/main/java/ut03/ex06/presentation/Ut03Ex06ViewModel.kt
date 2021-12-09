package ut03.ex06.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ut03.ex06.data.TapaDataRepository
import ut03.ex06.data.remote.MockDataSource
import ut03.ex06.domain.GetTapaUseCase
import ut03.ex06.domain.GetTapasUseCase

class Ut03Ex06ViewModel(
    private val getTapaUseCase: GetTapaUseCase,
    private val getTapasUseCase: GetTapasUseCase
) : ViewModel() {

    fun loadTapas() = viewModelScope.launch(Dispatchers.Main) {
        val result = getTapasUseCase.execute()
        result.mapCatching {
            Log.d("@tijani", "$result")
        }
    }

    fun loadTapa(tapaId: String) = viewModelScope.launch(Dispatchers.Main) {
        val result = getTapaUseCase.execute(tapaId)
        result.mapCatching {
            Log.d("@tijani", "$result")
        }

    }
}
package ut03.ex06.presentation
import ut03.ex06.data.TapaDataRepository
import ut03.ex06.data.local.TapaLocalSource
import ut03.ex06.data.remote.MockDataSource
import ut03.ex06.domain.GetTapaUseCase
import ut03.ex06.domain.GetTapasUseCase

class TapaViewModelFactory {
    companion object {
        fun build(tapaLocalSource: TapaLocalSource): Ut03Ex06ViewModel {
            val repository =
                TapaDataRepository(MockDataSource(),tapaLocalSource)
            return Ut03Ex06ViewModel(GetTapaUseCase(repository), GetTapasUseCase(repository))
        }
    }
}
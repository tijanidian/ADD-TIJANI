package ut03.ex06.presentation

import ut03.ex06.domain.TapaModel

data class TapasViewState(
    val isLoading: Boolean,
    val tapaModels: List<TapaModel>?,
    val failure: Throwable?
)

data class TapaViewState(
    val isLoading: Boolean,
    val tapaModels: TapaModel?,
    val failure: Throwable?
)
package data

import data.database.Vet

data class SearchState(
    val loading: Boolean = true,
    val results: List<Vet> = emptyList(),
)

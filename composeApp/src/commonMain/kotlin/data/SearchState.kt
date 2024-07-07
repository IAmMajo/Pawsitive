package data

import data.database.Vet

data class SearchState(
    val loading: Boolean = true,
    val query: String = "",
    val results: List<Vet> = emptyList(),
)

package ui

import androidx.lifecycle.ViewModel
import data.SearchState
import data.database.Vet
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SearchViewModel : ViewModel() {
  private val _uiState = MutableStateFlow(SearchState())
  val uiState: StateFlow<SearchState> = _uiState.asStateFlow()

  suspend fun fetchResults() {
    _uiState.update { it.copy(loading = false, results = getVetsList(it.query)) }
  }
  
  fun updateQuery(query: String) {
    _uiState.update { it.copy(loading = true, query = query) }
  }
}

expect suspend fun getVetsList(query: String): List<Vet>

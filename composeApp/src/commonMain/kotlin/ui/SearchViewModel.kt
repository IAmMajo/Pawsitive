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
    if (!_uiState.value.loading) {
      _uiState.update { currentState -> currentState.copy(loading = true) }
    }
    _uiState.update { currentState -> currentState.copy(results = getVetsList(), loading = false) }
  }
}

expect suspend fun getVetsList(): List<Vet>

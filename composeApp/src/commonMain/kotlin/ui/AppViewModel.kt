package ui

import Screen
import androidx.lifecycle.ViewModel
import data.AppState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AppViewModel : ViewModel() {
  private val _uiState = MutableStateFlow(AppState())
  val uiState: StateFlow<AppState> = _uiState.asStateFlow()

  fun setSection(section: Screen) {
    _uiState.update { it.copy(section = section) }
  }
}

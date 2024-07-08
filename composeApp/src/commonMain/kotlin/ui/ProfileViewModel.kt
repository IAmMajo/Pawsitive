package ui

import androidx.lifecycle.ViewModel
import data.ProfileState
import data.database.Pet
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ProfileViewModel : ViewModel() {
  private val _uiState = MutableStateFlow(ProfileState())
  val uiState: StateFlow<ProfileState> = _uiState.asStateFlow()

  suspend fun load() {
    _uiState.update { it.copy(loading = false, email = getEmail(), pets = getPetsList()) }
  }

  fun startLogout() {
    _uiState.update { it.copy(loading = true, email = "", logout = true) }
  }

  suspend fun executeLogout() {
    logout()
    _uiState.update { it.copy(loading = false, logout = false) }
  }
}

expect suspend fun getEmail(): String

expect suspend fun getPetsList(): List<Pet>

expect suspend fun logout()

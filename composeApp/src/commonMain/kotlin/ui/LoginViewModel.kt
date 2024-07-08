package ui

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import data.LoginState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel(private val navController: NavController) : ViewModel() {
  private val _uiState = MutableStateFlow(LoginState())
  val uiState: StateFlow<LoginState> = _uiState.asStateFlow()

  fun updateEmail(email: String) {
    _uiState.update { it.copy(email = email) }
  }

  fun updatePassword(password: String) {
    _uiState.update { it.copy(password = password.trim()) }
  }

  fun startLoading() {
    _uiState.update { it.copy(loading = true, error = false) }
  }

  suspend fun login() {
    val uiStateValue = uiState.value
    if (login(uiStateValue.email, uiStateValue.password)) {
      navController.navigate(Screen.Profile.name)
      return
    }
    _uiState.update { it.copy(loading = false, error = true) }
  }
}

expect suspend fun login(email: String, password: String): Boolean

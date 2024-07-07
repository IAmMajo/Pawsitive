package ui

import androidx.lifecycle.ViewModel
import data.ClinicState
import data.database.Clinic
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ClinicViewModel(): ViewModel() {
  private val _uiState = MutableStateFlow(ClinicState())
  val uiState: StateFlow<ClinicState> = _uiState.asStateFlow()

  suspend fun loadClinic(clinicId: String) {
    val clinic = getClinic(clinicId);
    _uiState.update { it.copy(clinic = clinic) }
    _uiState.update { it.copy(imageUrl = clinic.getImageUrl()) }
  }
}

expect suspend fun getClinic(clinicId: String): Clinic

package data

import data.database.Clinic

data class ClinicState(
  val clinic: Clinic? = null,
  val imageUrl: String = "",
)

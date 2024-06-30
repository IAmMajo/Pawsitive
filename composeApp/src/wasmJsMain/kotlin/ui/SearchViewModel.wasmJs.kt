package ui

import data.database.Vet

actual suspend fun getVetsList(): List<Vet> {
  return emptyList<Vet>()
}

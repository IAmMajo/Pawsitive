package ui

import data.database.Vet

actual suspend fun getVetsList(query: String): List<Vet> {
  return emptyList<Vet>()
}

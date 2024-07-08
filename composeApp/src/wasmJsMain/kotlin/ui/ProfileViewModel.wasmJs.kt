package ui

import data.database.Pet

actual suspend fun getEmail(): String {
  return ""
}

actual suspend fun logout() {}

actual suspend fun getPetsList(): List<Pet> {
  return emptyList()
}

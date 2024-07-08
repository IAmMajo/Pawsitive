package data

import data.database.Pet

data class ProfileState(
    val loading: Boolean = true,
    val email: String = "",
    val pets: List<Pet> = emptyList(),
    val logout: Boolean = false,
)

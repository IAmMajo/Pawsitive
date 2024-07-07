package data.database

import kotlinx.datetime.LocalDate

interface Pet {
  val id: String
  val name: String
  val imagePath: String
  val species: String
  val breed: String
  val birthDate: LocalDate?
  val vetRatings: List<VetRating>
  val clinicRatings: List<ClinicRating>

  suspend fun getImageUrl(): String
}

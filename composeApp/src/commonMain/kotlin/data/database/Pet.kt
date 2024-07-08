package data.database

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.yearsUntil

interface Pet {
  val id: String
  val name: String
  val imagePath: String
  val species: String
  val breed: String
  val birthDate: LocalDate?
  val vetRatings: List<VetRating>
  val clinicRatings: List<ClinicRating>

  val age: Int?
    get() =
        birthDate?.yearsUntil(Clock.System.now().toLocalDateTime(TimeZone.of("Europe/Berlin")).date)

  suspend fun getImageUrl(): String
}

package data.database

import kotlinx.datetime.LocalDateTime

interface ClinicRating {
  val id: String
  val clinic: Clinic?
  val rating: Double
  val comment: String
  val pets: List<Pet>
  val date: LocalDateTime
}

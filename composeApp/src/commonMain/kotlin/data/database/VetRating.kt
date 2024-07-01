package data.database

import kotlinx.datetime.LocalDateTime

interface VetRating {
  val id: String
  val vet: Vet?
  val ratingDiagnosis: Double
  val ratingTreatment: Double
  val ratingEmpathy: Double
  val comment: String
  val services: List<Service>
  val pets: List<Pet>
  val date: LocalDateTime

  val rating: Double
    get() = listOf(ratingDiagnosis, ratingTreatment, ratingEmpathy).filter { it != 0.0 }.average()
}

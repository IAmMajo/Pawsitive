package data.database

import extensions.averageNotZero
import kotlinx.datetime.Instant

interface VetRating {
  val id: String
  val vet: Vet?
  val ratingDiagnosis: Int
  val ratingTreatment: Int
  val ratingInformation: Int
  val ratingTrust: Int
  val ratingInvestedTime: Int
  val ratingFriendliness: Int
  val comment: String
  val services: List<Service>
  val pets: List<Pet>
  val date: Instant

  val rating: Double
    get() =
        listOf(
                // Double weighting
                ratingDiagnosis,
                ratingTreatment,
                ratingInformation,
                ratingDiagnosis,
                ratingTreatment,
                ratingInformation,
                // Single weighting
                ratingTrust,
                ratingInvestedTime,
                ratingFriendliness,
            )
            .averageNotZero()
}

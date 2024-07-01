package data.database

import extensions.averageNotZero
import kotlinx.datetime.Instant

interface ClinicRating {
  val id: String
  val clinic: Clinic?
  val ratingWaitingTime: Int
  val ratingEquipment: Int
  val ratingPhoneAvailability: Int
  val ratingParking: Int
  val ratingPricePerformance: Int
  val ratingAlternativeMedicine: Int
  val comment: String
  val pets: List<Pet>
  val date: Instant

  val rating: Double
    get() =
        listOf(
                ratingWaitingTime,
                ratingEquipment,
                ratingPhoneAvailability,
                ratingParking,
                ratingPricePerformance,
                ratingAlternativeMedicine,
            )
            .averageNotZero()
}

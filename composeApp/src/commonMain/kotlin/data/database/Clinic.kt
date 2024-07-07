package data.database

import extensions.averageNotZero

interface Clinic {
  val id: String
  val name: String
  val street: String
  val houseNumber: String
  val addressDetails: String
  val postalCode: Int
  val place: String
  val latitude: Double
  val longitude: Double
  val openingHours: String
  val phone: String
  val email: String
  val website: String
  val vets: List<Vet>
  val ratings: List<ClinicRating>
  
  val streetAndHouseNumber: String
    get() = "$street $houseNumber"

  val shortAddress: String
    get() = "$streetAndHouseNumber, $place"

  val averageRating: Double
    get() = ratings.map { it.rating }.averageNotZero()

  val averageRatingWaitingTime: Double
    get() = ratings.map { it.ratingWaitingTime }.averageNotZero()

  val averageRatingEquipment: Double
    get() = ratings.map { it.ratingEquipment }.averageNotZero()

  val averageRatingPhoneAvailability: Double
    get() = ratings.map { it.ratingPhoneAvailability }.averageNotZero()

  val averageRatingParking: Double
    get() = ratings.map { it.ratingParking }.averageNotZero()

  val averageRatingPricePerformance: Double
    get() = ratings.map { it.ratingPricePerformance }.averageNotZero()

  val averageRatingAlternativeMedicine: Double
    get() = ratings.map { it.ratingAlternativeMedicine }.averageNotZero()

  suspend fun getImageUrl(): String
}

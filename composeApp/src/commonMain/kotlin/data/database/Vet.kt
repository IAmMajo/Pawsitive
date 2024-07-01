package data.database

import extensions.averageNotZero

interface Vet {
  val id: String
  val name: String
  val imageSource: String
  val specialization: String
  val clinic: Clinic?
  val ratings: List<VetRating>

  val averageRating: Double
    get() = ratings.map { it.rating }.averageNotZero()

  val averageRatingDiagnosis: Double
    get() = ratings.map { it.ratingDiagnosis }.averageNotZero()

  val averageRatingTreatment: Double
    get() = ratings.map { it.ratingTreatment }.averageNotZero()

  val averageRatingInformation: Double
    get() = ratings.map { it.ratingInformation }.averageNotZero()

  val averageRatingTrust: Double
    get() = ratings.map { it.ratingTrust }.averageNotZero()

  val averageRatingInvestedTime: Double
    get() = ratings.map { it.ratingInvestedTime }.averageNotZero()

  val averageRatingFriendliness: Double
    get() = ratings.map { it.ratingFriendliness }.averageNotZero()
}

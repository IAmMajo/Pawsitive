package data.database

import extensions.format

interface Vet {
  val id: String
  val name: String
  val imageSource: String
  val specialization: String
  val clinic: Clinic?
  val ratings: List<VetRating>

  val averageRating: String
    get() = ratings.map { it.rating }.filter { it != 0.0 }.average().format()

  val diagnosisRatingsAmount: Int
    get() = ratings.filter { it.ratingDiagnosis != 0.0 }.size

  val treatmentRatingsAmount: Int
    get() = ratings.filter { it.ratingTreatment != 0.0 }.size

  val empathyRatingsAmount: Int
    get() = ratings.filter { it.ratingEmpathy != 0.0 }.size

  val averageDiagnosisRating: String
    get() = (ratings.sumOf { it.ratingDiagnosis } / diagnosisRatingsAmount).format()

  val averageTreatmentRating: String
    get() = (ratings.sumOf { it.ratingTreatment } / treatmentRatingsAmount).format()

  val averageEmpathyRating: String
    get() = (ratings.sumOf { it.ratingEmpathy } / empathyRatingsAmount).format()
}

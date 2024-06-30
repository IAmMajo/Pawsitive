package data.database

interface Vet {
  val id: String
  val name: String
  val imageSource: String
  val specialization: String
  val clinic: Clinic?
  val ratings: List<VetRating>

  val averageRating: Double
    get() = ratings.map { it.rating }.filter { it != 0.0 }.average()

  val diagnosisRatingsAmount: Int
    get() = ratings.filter { it.ratingDiagnosis != 0.0 }.size

  val treatmentRatingsAmount: Int
    get() = ratings.filter { it.ratingTreatment != 0.0 }.size

  val empathyRatingsAmount: Int
    get() = ratings.filter { it.ratingEmpathy != 0.0 }.size

  val averageDiagnosisRating: Double
    get() = ratings.sumOf { it.ratingDiagnosis } / diagnosisRatingsAmount

  val averageTreatmentRating: Double
    get() = ratings.sumOf { it.ratingTreatment } / treatmentRatingsAmount

  val averageEmpathyRating: Double
    get() = ratings.sumOf { it.ratingEmpathy } / empathyRatingsAmount
}

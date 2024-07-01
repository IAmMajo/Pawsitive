package data.database

interface Clinic {
  val id: String
  val name: String
  val imageSource: String
  val street: String
  val houseNumber: String
  val addressDetails: String
  val postalCode: Int
  val place: String
  val longitude: Double
  val latitude: Double
  val phone: String
  val email: String
  val website: String
  val vets: List<Vet>
  val ratings: List<ClinicRating>
  
  val shortAddress: String
    get() = "$street $houseNumber, $place"

  val averageRating: Double
    get() = ratings.map { it.rating }.filter { it != 0.0 }.average()
}

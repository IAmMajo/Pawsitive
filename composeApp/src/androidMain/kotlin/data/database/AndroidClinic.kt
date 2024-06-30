package data.database

import com.amplifyframework.core.model.LoadedModelList
import com.amplifyframework.datastore.generated.model.Clinic as AmplifyClinic

class AndroidClinic(amplifyClinic: AmplifyClinic) : Clinic {
  override val id: String = amplifyClinic.id
  override val name: String = amplifyClinic.name
  override val imageSource: String = amplifyClinic.imagePath ?: ""
  override val street: String = amplifyClinic.street
  override val houseNumber: String = amplifyClinic.houseNumber
  override val addressDetails: String = amplifyClinic.addressDetails ?: ""
  override val postalCode: Int = amplifyClinic.postalCode
  override val place: String = amplifyClinic.place
  override val longitude: Double = amplifyClinic.longitude
  override val latitude: Double = amplifyClinic.latitude
  override val phone: String = amplifyClinic.phone ?: ""
  override val email: String = amplifyClinic.email ?: ""
  override val website: String = amplifyClinic.website ?: ""
  override val vets: List<AndroidVet> = run {
    val vetsReference = amplifyClinic.vets
    if (vetsReference is LoadedModelList) {
      vetsReference.items.map { AndroidVet(it) }
    } else {
      emptyList()
    }
  }
  override val ratings: List<AndroidClinicRating> = run {
    val ratingsReference = amplifyClinic.ratings
    if (ratingsReference is LoadedModelList) {
      ratingsReference.items.map { AndroidClinicRating(it) }
    } else {
      emptyList()
    }
  }
}

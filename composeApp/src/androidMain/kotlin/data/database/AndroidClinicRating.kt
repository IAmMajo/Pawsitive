package data.database

import com.amplifyframework.core.model.LoadedModelList
import com.amplifyframework.core.model.LoadedModelReference
import com.amplifyframework.datastore.generated.model.ClinicRating as AmplifyClinicRating
import kotlinx.datetime.Instant

class AndroidClinicRating(amplifyClinicRating: AmplifyClinicRating) :
    AmplifyWrapper(), ClinicRating {
  override val id: String = amplifyClinicRating.id
  override val clinic: AndroidClinic? =
      (amplifyClinicRating.clinic as? LoadedModelReference)?.value?.let { AndroidClinic(it) }
  override val ratingWaitingTime: Int = amplifyClinicRating.ratingWaitingTime ?: 0
  override val ratingEquipment: Int = amplifyClinicRating.ratingEquipment ?: 0
  override val ratingPhoneAvailability: Int = amplifyClinicRating.ratingPhoneAvailability ?: 0
  override val ratingParking: Int = amplifyClinicRating.ratingParking ?: 0
  override val ratingPricePerformance: Int = amplifyClinicRating.ratingPricePerformance ?: 0
  override val ratingAlternativeMedicine: Int = amplifyClinicRating.ratingAlternativeMedicine ?: 0
  override val comment: String = amplifyClinicRating.comment ?: ""
  override val pets: List<AndroidPet> = run {
    val petsReference = amplifyClinicRating.pets
    if (petsReference is LoadedModelList) {
      petsReference.items.mapNotNull {
        (it.pet as? LoadedModelReference)?.value?.let { amplifyPet -> AndroidPet(amplifyPet) }
      }
    } else {
      emptyList()
    }
  }
  override val date: Instant = temporalToDateTime(amplifyClinicRating.createdAt)
}

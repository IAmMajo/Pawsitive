package data.database

import com.amplifyframework.core.model.LoadedModelList
import com.amplifyframework.core.model.LoadedModelReference
import com.amplifyframework.datastore.generated.model.ClinicRating as AmplifyClinicRating
import kotlinx.datetime.LocalDateTime

class AndroidClinicRating(amplifyClinicRating: AmplifyClinicRating) : ClinicRating {
  override val id: String = amplifyClinicRating.id
  override val clinic: AndroidClinic? =
      (amplifyClinicRating.clinic as? LoadedModelReference)?.value?.let { AndroidClinic(it) }
  override val rating: Double = amplifyClinicRating.rating ?: 0.0
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
  override val date: LocalDateTime = LocalDateTime.parse(amplifyClinicRating.createdAt.format())
}

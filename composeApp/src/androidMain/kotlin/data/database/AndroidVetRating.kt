package data.database

import com.amplifyframework.core.model.LoadedModelList
import com.amplifyframework.core.model.LoadedModelReference
import com.amplifyframework.datastore.generated.model.VetRating as AmplifyVetRating
import kotlinx.datetime.LocalDateTime

class AndroidVetRating(amplifyVetRating: AmplifyVetRating) : VetRating {
  override val id: String = amplifyVetRating.id
  override val vet: AndroidVet? =
      (amplifyVetRating.vet as? LoadedModelReference)?.value?.let { AndroidVet(it) }
  override val ratingDiagnosis: Int = amplifyVetRating.ratingDiagnosis
  override val ratingTreatment: Int = amplifyVetRating.ratingTreatment
  override val ratingInformation: Int = amplifyVetRating.ratingInformation
  override val ratingTrust: Int = amplifyVetRating.ratingTrust ?: 0
  override val ratingInvestedTime: Int = amplifyVetRating.ratingInvestedTime ?: 0
  override val ratingFriendliness: Int = amplifyVetRating.ratingFriendliness ?: 0
  override val comment: String = amplifyVetRating.comment ?: ""
  override val services: List<AndroidService> = run {
    val servicesReference = amplifyVetRating.services
    if (servicesReference is LoadedModelList) {
      servicesReference.items.mapNotNull {
        (it.service as? LoadedModelReference)?.value?.let { amplifyService ->
          AndroidService(amplifyService)
        }
      }
    } else {
      emptyList()
    }
  }
  override val pets: List<AndroidPet> = run {
    val petsReference = amplifyVetRating.pets
    if (petsReference is LoadedModelList) {
      petsReference.items.mapNotNull {
        (it.pet as? LoadedModelReference)?.value?.let { amplifyPet -> AndroidPet(amplifyPet) }
      }
    } else {
      emptyList()
    }
  }
  override val date: LocalDateTime = LocalDateTime.parse(amplifyVetRating.createdAt.format())
}

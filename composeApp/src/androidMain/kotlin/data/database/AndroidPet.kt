package data.database

import com.amplifyframework.core.model.LoadedModelList
import com.amplifyframework.core.model.LoadedModelReference
import com.amplifyframework.datastore.generated.model.Pet as AmplifyPet
import kotlinx.datetime.LocalDate

class AndroidPet(amplifyPet: AmplifyPet) : Pet {
  override val id: String = amplifyPet.id
  override val name: String = amplifyPet.name
  override val imageSource: String = amplifyPet.imagePath ?: ""
  override val species: String = amplifyPet.species ?: ""
  override val breed: String = amplifyPet.breed ?: ""
  override val birthDate: LocalDate? = amplifyPet.birthDate?.format()?.let { LocalDate.parse(it) }
  override val vetRatings: List<AndroidVetRating> = run {
    val vetRatingsReference = amplifyPet.vetRatings
    if (vetRatingsReference is LoadedModelList) {
      vetRatingsReference.items.mapNotNull {
        (it.rating as? LoadedModelReference)?.value?.let { amplifyVetRating ->
          AndroidVetRating(amplifyVetRating)
        }
      }
    } else {
      emptyList()
    }
  }
  override val clinicRatings: List<AndroidClinicRating> = run {
    val clinicRatingsReference = amplifyPet.clinicRatings
    if (clinicRatingsReference is LoadedModelList) {
      clinicRatingsReference.items.mapNotNull {
        (it.rating as? LoadedModelReference)?.value?.let { amplifyClinicRating ->
          AndroidClinicRating(amplifyClinicRating)
        }
      }
    } else {
      emptyList()
    }
  }
}

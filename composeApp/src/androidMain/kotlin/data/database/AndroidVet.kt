package data.database

import com.amplifyframework.core.model.LoadedModelList
import com.amplifyframework.core.model.LoadedModelReference
import com.amplifyframework.datastore.generated.model.Vet as AmplifyVet

class AndroidVet(amplifyVet: AmplifyVet) : Vet {
  override val id: String = amplifyVet.id
  override val name: String = amplifyVet.name
  override val imageSource: String = amplifyVet.imagePath ?: ""
  override val specialization: String = amplifyVet.specialization ?: ""
  override val clinic: AndroidClinic? =
      (amplifyVet.clinic as? LoadedModelReference)?.value?.let { AndroidClinic(it) }
  override val ratings: List<AndroidVetRating> = run {
    val ratingsReference = amplifyVet.ratings
    if (ratingsReference is LoadedModelList) {
      ratingsReference.items.map { AndroidVetRating(it) }
    } else {
      emptyList()
    }
  }
}

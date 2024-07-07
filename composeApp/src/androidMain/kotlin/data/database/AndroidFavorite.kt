package data.database

import com.amplifyframework.core.model.LoadedModelReference
import com.amplifyframework.datastore.generated.model.Favorite as AmplifyFavorite

class AndroidFavorite(amplifyFavorite: AmplifyFavorite) : AmplifyWrapper(), Favorite {
  override val id: String = amplifyFavorite.id
  override val vet: AndroidVet? =
      (amplifyFavorite.vet as? LoadedModelReference)?.value?.let { AndroidVet(it) }
}

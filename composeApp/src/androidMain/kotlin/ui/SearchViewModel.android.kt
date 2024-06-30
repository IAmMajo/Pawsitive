package ui

import com.amplifyframework.api.graphql.model.ModelQuery
import com.amplifyframework.core.model.includes
import com.amplifyframework.datastore.generated.model.Vet as AmplifyVet
import com.amplifyframework.datastore.generated.model.VetPath
import com.amplifyframework.kotlin.core.Amplify
import data.database.AndroidVet
import data.database.Vet

actual suspend fun getVetsList(): List<Vet> {
  val data =
      Amplify.API.query(
              ModelQuery.list<AmplifyVet, VetPath>(AmplifyVet::class.java) {
                includes(it.clinic, it.ratings /*, it.ratings.pets, it.ratings.pets.pet*/)
              },
          )
          .data
  if (data != null) {
    return data.items.toList().map { AndroidVet(it) }
  }
  return emptyList()
}

package ui

import com.amplifyframework.api.graphql.model.ModelQuery
import com.amplifyframework.auth.AuthException
import com.amplifyframework.auth.AuthUserAttributeKey
import com.amplifyframework.datastore.generated.model.Pet as AmplifyPet
import com.amplifyframework.kotlin.core.Amplify
import data.database.AndroidPet
import data.database.Pet

actual suspend fun getEmail(): String {
  return try {
    Amplify.Auth.fetchUserAttributes().find { it.key == AuthUserAttributeKey.email() }!!.value
  } catch (error: AuthException) {
    ""
  }
}

actual suspend fun getPetsList(): List<Pet> {
  val data = Amplify.API.query(ModelQuery.list(AmplifyPet::class.java)).data
  if (data != null) {
    return data.items.toList().map { AndroidPet(it) }
  }
  return emptyList()
}

actual suspend fun logout() {
  Amplify.Auth.signOut()
}

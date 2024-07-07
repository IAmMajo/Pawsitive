package ui

import com.amplifyframework.api.graphql.model.ModelQuery
import com.amplifyframework.core.model.includes
import com.amplifyframework.datastore.generated.model.Clinic as AmplifyClinic
import com.amplifyframework.datastore.generated.model.ClinicPath
import com.amplifyframework.kotlin.core.Amplify
import data.database.AndroidClinic
import data.database.Clinic

actual suspend fun getClinic(clinicId: String): Clinic {
  return AndroidClinic(
      Amplify.API.query(
              ModelQuery.get<AmplifyClinic, ClinicPath>(AmplifyClinic::class.java, clinicId) {
                includes(it.vets, it.vets.ratings.pets.pet, it.ratings.pets.pet)
              },
          )
          .data,
  )
}

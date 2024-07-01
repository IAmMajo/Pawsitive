package data.database

import com.amplifyframework.datastore.generated.model.Service as AmplifyService

class AndroidService(amplifyService: AmplifyService) : Service {
  override val number: String = amplifyService.number
  override val name: String = amplifyService.name
}

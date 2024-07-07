package data.database

import com.amplifyframework.datastore.generated.model.Service as AmplifyService

class AndroidService(amplifyService: AmplifyService) : AmplifyWrapper(), Service {
  override val id: String = amplifyService.id
  override val name: String = amplifyService.name
}

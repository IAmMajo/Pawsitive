package data.database

import com.amplifyframework.core.model.temporal.Temporal
import com.amplifyframework.kotlin.core.Amplify
import com.amplifyframework.storage.StoragePath
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate

abstract class AmplifyWrapper {
  protected fun temporalToDate(temporal: Temporal.Date?): LocalDate? {
    return temporal?.format()?.let { LocalDate.parse(it) }
  }

  protected fun temporalToDateTime(temporal: Temporal.DateTime): Instant {
    return Instant.parse(temporal.format())
  }

  protected suspend fun getImageUrl(imagePath: String?): String {
    if (imagePath.isNullOrEmpty()) {
      return ""
    }
    return Amplify.Storage.getUrl(StoragePath.fromString(imagePath)).url.toString()
  }
}

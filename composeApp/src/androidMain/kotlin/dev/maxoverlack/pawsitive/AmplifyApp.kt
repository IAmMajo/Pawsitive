package dev.maxoverlack.pawsitive

import android.app.Application
import com.amplifyframework.api.aws.AWSApiPlugin
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin
import com.amplifyframework.core.configuration.AmplifyOutputs
import com.amplifyframework.kotlin.core.Amplify
import kotlinx.coroutines.runBlocking
import org.jetbrains.compose.resources.ExperimentalResourceApi
import pawsitive.composeapp.generated.resources.Res

class AmplifyApp : Application() {
  @OptIn(ExperimentalResourceApi::class)
  override fun onCreate() {
    super.onCreate()

    Amplify.addPlugin(AWSCognitoAuthPlugin())
    Amplify.addPlugin(AWSApiPlugin())
    Amplify.configure(
        AmplifyOutputs(runBlocking { Res.readBytes("files/amplify_outputs.json") }.decodeToString()),
        applicationContext,
    )
  }
}

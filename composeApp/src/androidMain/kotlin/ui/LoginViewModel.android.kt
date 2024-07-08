package ui

import com.amplifyframework.auth.AuthException
import com.amplifyframework.kotlin.core.Amplify

actual suspend fun login(email: String, password: String): Boolean {
  try {
    Amplify.Auth.signIn(email, password)
    return true
  } catch (error: AuthException) {
    return false
  }
}

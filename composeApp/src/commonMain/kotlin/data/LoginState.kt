package data

data class LoginState(
    val email: String = "",
    val password: String = "",
    val loading: Boolean = false,
    val error: Boolean = false,
)

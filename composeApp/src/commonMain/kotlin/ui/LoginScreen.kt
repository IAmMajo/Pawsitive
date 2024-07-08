package ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import pawsitive.composeapp.generated.resources.Res
import pawsitive.composeapp.generated.resources.email
import pawsitive.composeapp.generated.resources.login
import pawsitive.composeapp.generated.resources.login_error
import pawsitive.composeapp.generated.resources.password
import ui.theme.greenTextColor
import ui.theme.textFieldColor

@Preview
@Composable
fun LoginScreen(navController: NavController) {
  val viewModel = viewModel { LoginViewModel(navController) }
  val uiState by viewModel.uiState.collectAsState()
  Column(
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally,
      modifier = Modifier.fillMaxSize(),
  ) {
    if (uiState.loading) {
      LaunchedEffect(true) { viewModel.login() }
      CircularProgressIndicator()
    } else {
      if (uiState.error) {
        Text(stringResource(Res.string.login_error), color = MaterialTheme.colorScheme.error)
      }
      OutlinedTextField(
          uiState.email,
          modifier = Modifier.padding(vertical = 5.dp),
          onValueChange = { viewModel.updateEmail(it) },
          label = { Text(stringResource(Res.string.email)) },
          keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
          singleLine = true,
          colors =
              OutlinedTextFieldDefaults.colors(
                  unfocusedBorderColor = textFieldColor,
                  unfocusedLabelColor = textFieldColor,
                  focusedBorderColor = greenTextColor,
                  focusedLabelColor = greenTextColor,
              ),
      )
      OutlinedTextField(
          uiState.password,
          modifier = Modifier.padding(vertical = 5.dp),
          onValueChange = { viewModel.updatePassword(it) },
          label = { Text(stringResource(Res.string.password)) },
          visualTransformation = PasswordVisualTransformation(),
          keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
          singleLine = true,
          colors =
              OutlinedTextFieldDefaults.colors(
                  unfocusedBorderColor = textFieldColor,
                  unfocusedLabelColor = textFieldColor,
                  focusedBorderColor = greenTextColor,
                  focusedLabelColor = greenTextColor,
              ),
      )
      Button({ viewModel.startLoading() }, modifier = Modifier.padding(vertical = 5.dp)) {
        Text(stringResource(Res.string.login))
      }
    }
  }
}

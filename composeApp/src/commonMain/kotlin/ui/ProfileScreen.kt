package ui

import Screen
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import coil3.compose.LocalPlatformContext
import coil3.request.ImageRequest
import coil3.request.crossfade
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import pawsitive.composeapp.generated.resources.Illustration
import pawsitive.composeapp.generated.resources.Res
import pawsitive.composeapp.generated.resources.gecko
import pawsitive.composeapp.generated.resources.logged_in_as
import pawsitive.composeapp.generated.resources.login
import pawsitive.composeapp.generated.resources.login_or_register
import pawsitive.composeapp.generated.resources.logout
import pawsitive.composeapp.generated.resources.pet_placeholder
import pawsitive.composeapp.generated.resources.register
import pawsitive.composeapp.generated.resources.years_old

@Composable
@Preview
fun ProfileScreen(navController: NavController) {
  val viewModel = viewModel { ProfileViewModel() }
  val uiState by viewModel.uiState.collectAsState()
  LaunchedEffect(true) { viewModel.load() }
  Column(
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center,
      modifier = Modifier.fillMaxHeight()) {
        if (uiState.loading) {
          if (uiState.logout) {
            LaunchedEffect(true) { viewModel.executeLogout() }
          }
          CircularProgressIndicator()
        } else {
          if (uiState.email.isEmpty()) {
            Text(
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                text = stringResource(Res.string.login_or_register))
            Image(
                painter = painterResource(Res.drawable.Illustration),
                contentDescription = "Beschreibung",
                modifier = Modifier.size(320.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()) {
                  Button(
                      { navController.navigate(Screen.Login.name) },
                      modifier = Modifier.padding(horizontal = 5.dp)) {
                        Text(stringResource(Res.string.login))
                      }
                  Button({}, modifier = Modifier.padding(horizontal = 5.dp)) {
                    Text(stringResource(Res.string.register))
                  }
                }
          } else {
            Text("${stringResource(Res.string.logged_in_as)}: ${uiState.email}")
            Button({ viewModel.startLogout() }) { Text(stringResource(Res.string.logout)) }
            uiState.pets.forEach {
              var petImageUrl by remember { mutableStateOf("") }
              LaunchedEffect(true) { petImageUrl = it.getImageUrl() }
              Box(
                  modifier =
                      Modifier.height(250.dp)
                          .clip(RoundedCornerShape(8.dp))
                          .padding(5.dp)
                          .fillMaxWidth(),
              ) {
                AsyncImage(
                    model =
                        ImageRequest.Builder(LocalPlatformContext.current)
                            .data(petImageUrl)
                            .crossfade(true)
                            .build(),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize().clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(Res.drawable.pet_placeholder),
                    error = painterResource(Res.drawable.pet_placeholder),
                )
                Column(
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier.fillMaxSize(),
                ) {
                  Text(
                      text = "${it.name} (${it.age} ${stringResource(Res.string.years_old)})",
                      color = Color.LightGray,
                      fontWeight = FontWeight.Bold,
                      fontSize = 22.sp,
                      modifier = Modifier.padding(horizontal = 16.dp),
                  )
                  Text(
                      text = it.species,
                      color = Color.LightGray,
                      fontWeight = FontWeight.SemiBold,
                      fontSize = 18.sp,
                      modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 6.dp),
                  )
                }
              }
            }
            Box(
                modifier =
                    Modifier.height(250.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .padding(5.dp)
                        .fillMaxWidth(),
            ) {
              Image(
                  painter = painterResource(Res.drawable.gecko),
                  contentDescription = null,
                  contentScale = ContentScale.Crop,
                  modifier = Modifier.fillMaxSize().clip(RoundedCornerShape(8.dp)),
              )
              Column(
                  verticalArrangement = Arrangement.Bottom,
                  horizontalAlignment = Alignment.Start,
                  modifier = Modifier.fillMaxSize(),
              ) {
                Text(
                    text = "Thomas (19 Jahre alt)",
                    color = Color.LightGray,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    modifier = Modifier.padding(horizontal = 16.dp),
                )
                Text(
                    text = "Stirnlappenbasilisk",
                    color = Color.LightGray,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 6.dp),
                )
              }
            }
          }
        }
      }
}

// Hier könnte man dann auch die Ärzte eintragen, die man bereits besucht hat
// DB Anbindung

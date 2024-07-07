import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import pawsitive.composeapp.generated.resources.Res
import pawsitive.composeapp.generated.resources.map
import pawsitive.composeapp.generated.resources.profile
import pawsitive.composeapp.generated.resources.rate
import pawsitive.composeapp.generated.resources.search
import ui.AppViewModel
import ui.ClinicScreen
import ui.CompletedRateScreen
import ui.MapScreen
import ui.ProfileScreen
import ui.RateScreen
import ui.SearchScreen
import ui.theme.AppTheme
import ui.theme.NavbarModifier

/// CLASSES ///
enum class Screen {
  Search,
  Rate,
  Map,
  Profile,
  Clinic,
  Completed
}

////// COMPOSABLE SECTION ///////
@Composable
@Preview
fun App() {
  val navController = rememberNavController()
  val viewModel = viewModel { AppViewModel() }
  val uiState by viewModel.uiState.collectAsState()
  AppTheme {
    Scaffold(
        bottomBar = {
          NavigationBar(containerColor = Color.White, modifier = NavbarModifier) {
            NavigationBarItem(
                selected = uiState.section === Screen.Search,
                onClick = {
                  viewModel.setSection(Screen.Search)
                  navController.navigate(Screen.Search.name)
                },
                icon = { Icon(Icons.Outlined.Star, stringResource(Res.string.search)) },
                label = { Text(stringResource(Res.string.search)) })
            NavigationBarItem(
                selected = uiState.section === Screen.Rate,
                onClick = {
                  viewModel.setSection(Screen.Rate)
                  navController.navigate(Screen.Rate.name)
                },
                icon = { Icon(Icons.Outlined.Star, stringResource(Res.string.rate)) },
                label = { Text(stringResource(Res.string.rate)) })
            NavigationBarItem(
                selected = uiState.section === Screen.Map,
                onClick = {
                  viewModel.setSection(Screen.Map)
                  navController.navigate(Screen.Map.name)
                },
                icon = { Icon(Icons.Outlined.Search, stringResource(Res.string.map)) },
                label = { Text(stringResource(Res.string.map)) })
            NavigationBarItem(
                selected = uiState.section === Screen.Profile,
                onClick = {
                  viewModel.setSection(Screen.Profile)
                  navController.navigate(Screen.Profile.name)
                },
                icon = { Icon(Icons.Outlined.Search, stringResource(Res.string.profile)) },
                label = { Text(stringResource(Res.string.profile)) })
          }
        }) {
          NavHost(
              navController = navController,
              startDestination = Screen.Search.name,
              modifier = Modifier.padding(it),
          ) {
            composable(route = Screen.Search.name) { SearchScreen(navController) }
            composable(route = Screen.Rate.name) { RateScreen(navController) }
            composable(route = Screen.Map.name) { MapScreen() }
            composable(route = Screen.Profile.name) { ProfileScreen() }
            composable(
                route = "${Screen.Clinic.name}/{clinicId}",
                arguments = listOf(navArgument("clinicId") {}),
            ) { backStackEntry ->
              ClinicScreen(navController, backStackEntry.arguments!!.getString("clinicId")!!)
            }
            composable(route = Screen.Completed.name) { CompletedRateScreen() }
          }
        }
  }
}

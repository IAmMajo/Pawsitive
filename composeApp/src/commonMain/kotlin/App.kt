import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose.AppTheme
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import pawsitive.composeapp.generated.resources.Res
import pawsitive.composeapp.generated.resources.favorites
import pawsitive.composeapp.generated.resources.map
import pawsitive.composeapp.generated.resources.profile
import pawsitive.composeapp.generated.resources.rate
import pawsitive.composeapp.generated.resources.search
import ui.AppViewModel
import ui.FavoritesScreen
import ui.MapScreen
import ui.ProfileScreen
import ui.RateScreen
import ui.SearchScreen

enum class Screen {
    Search,
    Rate,
    Favorites,
    Map,
    Profile,
}

@Composable
@Preview
fun App() {
    val navController = rememberNavController()
    val viewModel = viewModel { AppViewModel() };
    val uiState by viewModel.uiState.collectAsState()
    AppTheme {
        Scaffold (
            bottomBar = {
                NavigationBar(
                    modifier =
                        Modifier
                            .padding(Dp(10f))
                            .clip(RoundedCornerShape(Dp(20f)))
                )
                {
                    NavigationBarItem(
                        selected = uiState.section === Screen.Search,
                        onClick = {
                            viewModel.setSection(Screen.Search)
                            navController.navigate(Screen.Search.name)
                        },
                        icon = {
                            Icon(Icons.Outlined.Star, stringResource(Res.string.search))
                        },
                        label = {
                            Text(stringResource(Res.string.search))
                        }
                    )
                    NavigationBarItem(
                        selected = uiState.section === Screen.Favorites,
                        onClick = {
                            viewModel.setSection(Screen.Favorites)
                            navController.navigate(Screen.Favorites.name)
                        },
                        icon = {
                            Icon(Icons.Outlined.Star, stringResource(Res.string.favorites))
                        },
                        label = {
                            Text(stringResource(Res.string.favorites))
                        }
                    )
                    NavigationBarItem(
                        selected = uiState.section === Screen.Rate,
                        onClick = {
                            viewModel.setSection(Screen.Rate)
                            navController.navigate(Screen.Rate.name)
                        },
                        icon = {
                            Icon(Icons.Outlined.Star, stringResource(Res.string.rate))
                        },
                        label = {
                            Text(stringResource(Res.string.rate))
                        }
                    )
                    NavigationBarItem(
                        selected = uiState.section === Screen.Map,
                        onClick = {
                            viewModel.setSection(Screen.Map)
                            navController.navigate(Screen.Map.name)
                        },
                        icon = {
                            Icon(Icons.Outlined.Search, stringResource(Res.string.map))
                        },
                        label = {
                            Text(stringResource(Res.string.map))
                        }
                    )
                    NavigationBarItem(
                        selected = uiState.section === Screen.Profile,
                        onClick = {
                            viewModel.setSection(Screen.Profile)
                            navController.navigate(Screen.Profile.name)
                        },
                        icon = {
                            Icon(Icons.Outlined.Search, stringResource(Res.string.profile))
                        },
                        label = {
                            Text(stringResource(Res.string.profile))
                        }
                    )
                }
            }
        ) {
            NavHost(navController = navController, startDestination = Screen.Search.name) {
                composable(route = Screen.Search.name) {
                    SearchScreen()
                }
                composable(route = Screen.Rate.name) {
                    RateScreen()
                }
                composable(route = Screen.Favorites.name) {
                    FavoritesScreen()
                }
                composable(route = Screen.Map.name) {
                    MapScreen()
                }
                composable(route = Screen.Profile.name) {
                    ProfileScreen()
                }
            }
        }
    }
}
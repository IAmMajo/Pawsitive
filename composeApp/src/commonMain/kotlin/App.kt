import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.ui.tooling.preview.Preview
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
    var navController = rememberNavController()
    MaterialTheme {
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
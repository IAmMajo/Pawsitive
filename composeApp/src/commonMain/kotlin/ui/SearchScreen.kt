package ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import ui.components.ListEntryComponent
import ui.components.Searchbar

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun SearchScreen(navController: NavController) {
  val state = rememberScrollState()
  val viewModel = viewModel { SearchViewModel() }
  val uiState by viewModel.uiState.collectAsState()
  val drawerState = rememberDrawerState(DrawerValue.Closed)
  val scope = rememberCoroutineScope()

  LaunchedEffect(true) { viewModel.fetchResults() }

  ModalNavigationDrawer(
      modifier = Modifier.background(Color.White),
      drawerState = drawerState,
      drawerContent = {
        ModalDrawerSheet(modifier = Modifier.background(Color.White)) {
          Column(Modifier.padding(16.dp)) {
            DropdownMenuComponent("Tierart")
            Spacer(modifier = Modifier.height(16.dp))
            DropdownMenuComponent("Umkreis")
            Spacer(modifier = Modifier.height(16.dp))
            DropdownMenuComponent("Straße")
          }
        }
      },
      content = {
        Scaffold(
            topBar = {
              TopAppBar(
                  title = { Text("") },
                  navigationIcon = {
                    IconButton(onClick = { scope.launch { drawerState.open() } }) {
                      Icon(Icons.Default.Menu, contentDescription = "Menu")
                    }
                  },
                  colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent))
            }) {
              Column(
                  Modifier.fillMaxWidth().verticalScroll(state).padding(it),
                  horizontalAlignment = Alignment.CenterHorizontally,
              ) {
                Searchbar()
                if (uiState.loading) {
                  CircularProgressIndicator()
                } else {
                  uiState.results.forEach { ListEntryComponent(navController, it) }
                }
              }
            }
      })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownMenuComponent(label: String) {
  var expanded by remember { mutableStateOf(false) }
  var selectedText by remember { mutableStateOf("") }
  val items = listOf("Item 1", "Item 2", "Item 3")

  Column() {
    Text(text = label, fontWeight = FontWeight.SemiBold)
    ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = { expanded = !expanded }) {
      TextField(
          value = selectedText,
          onValueChange = { selectedText = it },
          readOnly = true,
          label = { Text("Select Item") },
          trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
          modifier = Modifier.menuAnchor())
      ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
        items.forEach { item ->
          DropdownMenuItem(
              onClick = {
                selectedText = item
                expanded = false
              },
              text = { Text(text = item) })
        }
      }
    }
  }
}

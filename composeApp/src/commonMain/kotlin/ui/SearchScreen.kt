package ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import ui.components.ListEntryComponent
import ui.components.Searchbar

@Composable
@Preview
fun SearchScreen() {
  val viewModel = viewModel { SearchViewModel() }
  val uiState by viewModel.uiState.collectAsState()
  LaunchedEffect(true) { viewModel.fetchResults() }
  Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
    Searchbar()

    if (uiState.loading) {
      CircularProgressIndicator()
    } else {
      uiState.results.forEach {
        ListEntryComponent(it)
      }
    }
  }
}

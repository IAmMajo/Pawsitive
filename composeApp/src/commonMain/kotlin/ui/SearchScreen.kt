package ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview
import ui.components.ListEntryComponent
import ui.components.Searchbar

@Composable
@Preview
fun SearchScreen() {
  Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
   
    Searchbar()
    
    ListEntryComponent()
    ListEntryComponent()
  }
}

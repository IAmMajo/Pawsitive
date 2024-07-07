package ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import data.SearchState
import ui.SearchViewModel
import ui.theme.SearchbarModifier
import ui.theme.greenTextColor
import ui.theme.textFieldColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Searchbar(viewModel: SearchViewModel, uiState: SearchState) {
  Row(modifier = SearchbarModifier.padding(4.dp)) {
    OutlinedTextField(
        colors =
            TextFieldDefaults.outlinedTextFieldColors(
                unfocusedLabelColor = textFieldColor,
                focusedLabelColor = greenTextColor,
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = Color.Transparent,
            ),
        value = uiState.query,
        onValueChange = { viewModel.updateQuery(it) },
        label = { Text("Search...", color = Color.Gray) },
        trailingIcon = {
          Icon(
              imageVector = Icons.Outlined.Search,
              tint = Color.Gray,
              contentDescription = "Such-Icon",
              modifier = Modifier.padding(end = 8.dp),
          )
        },
        modifier = Modifier.weight(1f),
    )
  }
}

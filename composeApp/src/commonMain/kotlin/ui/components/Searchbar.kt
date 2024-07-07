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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ui.theme.SearchbarModifier
import ui.theme.greenTextColor
import ui.theme.textFieldColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Searchbar() {
  val searchText = remember { mutableStateOf("") }

  Row(modifier = SearchbarModifier.padding(4.dp)) {
    OutlinedTextField(
        colors =
            TextFieldDefaults.outlinedTextFieldColors(
                unfocusedLabelColor = textFieldColor,
                focusedLabelColor = greenTextColor,
                unfocusedBorderColor = textFieldColor,
                focusedBorderColor = greenTextColor,
            ),
        value = searchText.value,
        onValueChange = { searchText.value = it },
        placeholder = { Text("Search...", color = Color.Gray) },
        trailingIcon = {
          Icon(
              imageVector = Icons.Outlined.Search,
              tint = Color.Gray,
              contentDescription = "Such-Icon",
              modifier = Modifier.padding(end = 8.dp))
        },
        modifier = Modifier.weight(1f))
  }
}

package ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

val SearchbarModifier =
    Modifier.padding(10.dp)
        .clip(RoundedCornerShape(15.dp))
        .shadow(elevation = 20.dp, spotColor = Color(0xff3a3a3a))
        .background(Color.White)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Searchbar() {
  val searchText = remember { mutableStateOf("") }

  Row(modifier = SearchbarModifier.padding(8.dp)) {
    OutlinedTextField(
        colors =
            TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.White, unfocusedBorderColor = Color.White),
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

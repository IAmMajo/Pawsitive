package ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import org.jetbrains.compose.ui.tooling.preview.Preview

val ProfileCardModifier = Modifier
  .padding(Dp(10f))
  .background(color = Color.Red)



@Composable
@Preview
fun ProfileScreen() {
  
  Column(
    verticalArrangement = Arrangement.Bottom,
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = ProfileCardModifier
      .padding(Dp(10f))
  ) {
    Row {
      Text(text ="Thomas")
      Text(text = "19 Jahre alt")
    }
  Text(text = "Stirnlappenbasikisk")  
  }
  Text(text = "ProfileScreen")
}

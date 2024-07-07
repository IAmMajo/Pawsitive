package ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import org.jetbrains.compose.ui.tooling.preview.Preview
import ui.components.FeedbackComponent

@Composable
@Preview
fun RateScreen(navController: NavController) {

  Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
    FeedbackComponent(navController)
  }
}

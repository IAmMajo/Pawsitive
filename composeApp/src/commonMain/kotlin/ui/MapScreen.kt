package ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import pawsitive.composeapp.generated.resources.Map
import pawsitive.composeapp.generated.resources.Res



@Composable @Preview fun MapScreen() {
  
  Box(){
    Box(
      modifier = Modifier
        .fillMaxSize()
    ) {
      Image(
        painter = painterResource(Res.drawable.Map),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
          .fillMaxSize()
      )
    }
  }
  
}

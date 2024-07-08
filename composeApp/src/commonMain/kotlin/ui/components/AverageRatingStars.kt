package ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import ui.theme.starNotSelectedColor
import ui.theme.starSelectedColor

@Composable
fun AverageStars(
    stars: Int = 5,
    rating: Double = 0.0,
) {

  for (index in 1..stars) {
    Icon(
        Icons.Rounded.Star,
        contentDescription = "Star Placeholder Icon",
        modifier = StarIconModifier.size(24.dp),
        // ausgewählte Sterne grün; Rest grau
        tint = if (rating >= index) starSelectedColor else starNotSelectedColor,
    )
  }
  /*
  Icon(
    Icons.Rounded.Star,
    contentDescription = "Star Placeholder Icon",
    tint = starNotSelectedColor,
    modifier = StarModifier,
  )
  */

}

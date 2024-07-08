package ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.theme.starNotSelectedColor
import ui.theme.starSelectedColor

@Composable
fun StarRow(
    modifier: Modifier,
    rating: Double = 0.0,
    stars: Int = 5,
    onRatingChange: (Double) -> Unit
) {

  Row(
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.SpaceBetween,
  ) {
    var isHalfStar = (rating % 1) != 0.0

    // Schleife zum Sterne erstellen
    for (index in 1..stars) {
      Icon(
          Icons.Rounded.Star,
          contentDescription = "Star Placeholder Icon",
          modifier = StarIconModifier.clickable { onRatingChange(index.toDouble()) }.size(24.dp),
          // ausgewählte Sterne grün; Rest grau
          tint = if (rating >= index) starSelectedColor else starNotSelectedColor,
      )
      /*
       if (isHalfStar){
         isHalfStar = false
         Icons.Rounded.StarHalf
       } else {
         Icons.Rounded.StarBorder
       }
      */
    }
  }
}

package ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.DraggableAnchors
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ui.theme.secondaryButtonColor
import ui.theme.starNotSelectedColor
import ui.theme.starSelectedColor
import kotlin.math.roundToInt

@Composable
fun StarRow(
  modifier: Modifier,
  rating: Double = 0.0,
  stars: Int = 5,
  onRatingChange: (Double) -> Unit
){

  Row(
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceBetween,
  ) {

    // var isHalfStar = (rating % 1) != 0.0

    for (index in 1 .. stars){
      Icon(
        Icons.Rounded.Star,
        contentDescription = "Star Placeholder Icon",
        modifier = StarIconModifier
          .clickable{ onRatingChange(index.toDouble()) }
          .size(24.dp),
        tint = if (rating >= index) starSelectedColor else starNotSelectedColor,
      )
    }
    /*if (isHalfStar){
      isHalfStar = false
      Icons.Rounded.StarHalf
    } else {
      Icons.Rounded.StarOutlined
    }
  }*/
  }

}



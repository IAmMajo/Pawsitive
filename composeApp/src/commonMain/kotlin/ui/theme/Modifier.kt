package ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

///// CONTAINER MODIIFIER ///////

val CardModifier = Modifier
  .padding(Dp(10f))
  .clip(RoundedCornerShape(Dp(15f)))
  .shadow(elevation = Dp(20f), spotColor = Color(0xff3a3a3a))
  .background(Color.White)

val StarModifier = Modifier
  .size(24.dp)

val ProfilePictureModifier = Modifier
  .size(70.dp)
  .clip(CircleShape)

val ProfilePictureModifierSM = Modifier
  .size(35.dp)
  .clip(CircleShape)

val HeaderImageModifier = Modifier
  .fillMaxWidth()
  .height(240.dp)



/////  TEXT MODIFIER    ///////


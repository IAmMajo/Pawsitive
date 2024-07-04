package ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import pawsitive.composeapp.generated.resources.Res
import pawsitive.composeapp.generated.resources.praxis


// Hier ist die vorläufige Version der Praxis View drin, da ich immernoch nicht auf ListEntryComponents
// im Web zugreifen kann, werde ich die View jetzt hier reinschreiben, dann muss Max die kopieren.


@Composable
@Preview
fun ProfileScreen() {
  Column {
    // Header Image
    Image(
      modifier = Modifier
        .fillMaxWidth()
        .aspectRatio(painterResource(Res.drawable.praxis).intrinsicSize.width / painterResource(Res.drawable.praxis).intrinsicSize.height)
        .height(240.dp),
      painter = painterResource(Res.drawable.praxis),
      contentDescription = "Header Image der Praxis",
      contentScale = ContentScale.Crop
    )

    // Profile Image
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .padding(top = (-35).dp),
      contentAlignment = Alignment.Center
    ) {
      Image(
        modifier = Modifier
          .size(100.dp)
          .clip(CircleShape)
          .background(Color.White)
          .border(2.dp, Color.White, CircleShape)
          .padding(4.dp)
          .clip(CircleShape),
        painter = painterResource(Res.drawable.praxis),
        contentDescription = "Profile Picture",
        contentScale = ContentScale.Crop
      )
    }

    // Clinic Name
    Text(
      text = "Tierklinik Beispiel",
      fontWeight = FontWeight.Bold,
      fontSize = 24.sp,
      modifier = Modifier
        .padding(top = 8.dp)
        .align(Alignment.CenterHorizontally)
    )

    // Additional Information
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
    ) {

      Row(
        modifier = Modifier
          .padding(top = 2.dp),
        verticalAlignment = Alignment.CenterVertically
      ) {
        Icon(
          Icons.Rounded.Star,
          contentDescription = "Placeholder Icon",
          tint = Color(0xFF959494),
        )
        Text(
          text = "Schäferhunde",
          fontWeight = FontWeight.Medium,
          color = Color(0xFF959494)
        )
      }
      Row(
        modifier = Modifier
          .padding(top = 2.dp),
        verticalAlignment = Alignment.CenterVertically
      ) {
        Icon(
          Icons.Rounded.Star,
          contentDescription = "Placeholder Icon",
          tint = Color(0xFF959494),
        )
        Text(
          text = "Musterstraße 1",
          fontWeight = FontWeight.Medium,
          color = Color(0xFF959494)
        )
      }
      Row(
        modifier = Modifier
          .padding(top = 2.dp),
        verticalAlignment = Alignment.CenterVertically
      ) {
        Icon(
          Icons.Rounded.Star,
          contentDescription = "Placeholder Icon",
          tint = Color(0xFF959494),
        )
        Text(
          text = "2km",
          fontWeight = FontWeight.Medium,
          color = Color(0xFF959494)
        )
      }
      Row(
        modifier = Modifier
          .padding(top = 2.dp),
        verticalAlignment = Alignment.CenterVertically
      ) {
        Icon(
          Icons.Rounded.Star,
          contentDescription = "Placeholder Icon",
          tint = Color(0xFF959494),
        )
        Text(
          text = "123-456789",
          fontWeight = FontWeight.Medium,
          color = Color(0xFF959494)
        )
      }
    }
  }
}

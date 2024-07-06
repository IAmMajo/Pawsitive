package ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import pawsitive.composeapp.generated.resources.Res
import pawsitive.composeapp.generated.resources.praxis
import ui.theme.HeaderImageModifier
import ui.theme.StarModifier

@Composable
@Preview
fun PraxisScreen() {
  val state = rememberScrollState()
  Column(modifier = Modifier.verticalScroll(state)) {
    // Header Image
    Image(
      modifier =
      HeaderImageModifier.aspectRatio(
        painterResource(Res.drawable.praxis).intrinsicSize.width /
          painterResource(Res.drawable.praxis).intrinsicSize.height),
      painter = painterResource(Res.drawable.praxis),
      contentDescription = "Header Image der Praxis",
      contentScale = ContentScale.Crop)

    Column(modifier = Modifier.fillMaxWidth().background(Color.White)) {
      Column(modifier = Modifier.padding(top = 8.dp, start = 10.dp).fillMaxWidth()) {
        // Clinic Name
        Text(
          text = "Tierklinik Beispiel",
          fontWeight = FontWeight.Bold,
          fontSize = 20.sp,
          modifier = Modifier.align(Alignment.Start))

        Row {
          Icon(
            Icons.Rounded.Star,
            contentDescription = "Star Placeholder Icon",
            tint = Color(0xFF00D47B),
            modifier = StarModifier)
          Icon(
            Icons.Rounded.Star,
            contentDescription = "Star Placeholder Icon",
            tint = Color(0xFF00D47B),
            modifier = StarModifier)
          Icon(
            Icons.Rounded.Star,
            contentDescription = "Star Placeholder Icon",
            tint = Color(0xFF00D47B),
            modifier = StarModifier)
          Icon(
            Icons.Rounded.Star,
            contentDescription = "Star Placeholder Icon",
            tint = Color(0xFF00D47B),
            modifier = StarModifier)
          Icon(
            Icons.Rounded.Star,
            contentDescription = "Star Placeholder Icon",
            tint = Color(0xFF00D47B),
            modifier = StarModifier)
          Text(
            text = "4,7",
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF202020),
          )
        }
      }

      // Additional Information
      Column(modifier = Modifier.fillMaxWidth().padding(10.dp)) {
        Row(
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.SpaceBetween,
          modifier = Modifier.fillMaxWidth()) {
          Row(
            modifier = Modifier.padding(top = 2.dp),
            verticalAlignment = Alignment.CenterVertically) {
            Icon(
              Icons.Rounded.Star,
              contentDescription = "Placeholder Icon",
              tint = Color(0xffb9b9b9),
            )
            Text(
              text = "Musterstraße 1",
              fontWeight = FontWeight.Medium,
              color = Color(0xffb9b9b9))
          }
          Row(
            modifier = Modifier.padding(top = 2.dp),
            verticalAlignment = Alignment.CenterVertically) {
            Icon(
              Icons.Rounded.Star,
              contentDescription = "Placeholder Icon",
              tint = Color(0xffb9b9b9),
            )
            Text(
              text = "+49 1234 5678",
              fontWeight = FontWeight.Medium,
              color = Color(0xffb9b9b9))
          }
        }

        Row(
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.SpaceBetween,
          modifier = Modifier.fillMaxWidth()) {
          Row(
            modifier = Modifier.padding(top = 2.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start) {
            Icon(
              Icons.Rounded.Star,
              contentDescription = "Placeholder Icon",
              tint = Color(0xffb9b9b9),
            )
            Text(text = "2km", fontWeight = FontWeight.Medium, color = Color(0xffb9b9b9))
          }
        }
      }
      
    }
  }
}

//Einbindung der Ärzte, die in dieser Praxis arbeiten

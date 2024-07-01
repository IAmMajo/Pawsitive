package ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.Place
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import pawsitive.composeapp.generated.resources.Res
import pawsitive.composeapp.generated.resources.mockimage

// Nico aus ListEntry.kt geklaut :) //
val BoxModifier =
    Modifier.padding(start = 10.dp, end = 10.dp, top = 15.dp, bottom = 15.dp)
        .padding(Dp(10f)) // Eigentlich der Margin (Compose ist super weird)
        .clip(RoundedCornerShape(Dp(15f)))
        .shadow(elevation = Dp(20f), spotColor = Color(0xff3a3a3a))
        .background(Color.White)
        .fillMaxWidth()

val InnenEnrcken = Modifier.padding(horizontal = 10.dp, vertical = 10.dp)

// aus ListEntry.kt + abgeändert
val StarIconModifier = Modifier.size(24.dp).padding(vertical = 2.dp).padding(bottom = 6.dp)

@Composable
fun FeedbackComponent() {

  // Column Bewertung Arzt
  Column() {

    // Info-Card Arzt -> abgeänderte ListEntryComponent()
    Column(
        modifier = BoxModifier
        // .fillMaxWidth()
        // .padding(start = 10.dp, end = 10.dp, top = 15.dp, bottom = 15.dp)
        ) {
          Row(
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.SpaceBetween,
              modifier = Modifier.fillMaxWidth()) {
                // Nane + Bild
                Row(verticalAlignment = Alignment.CenterVertically) {
                  Image(
                      painter = painterResource(Res.drawable.mockimage),
                      contentDescription = "MockImage",
                      contentScale = ContentScale.Crop,
                      modifier = ProfilePictureModifier)

                  Column(
                      verticalArrangement = Arrangement.Center,
                      modifier = Modifier.padding(start = 5.dp)) {
                        Text(
                            text = "Rita Strauß",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF202020))
                        Row {
                          Icon(
                              Icons.Rounded.Star,
                              contentDescription = "Star Placeholder Icon",
                              tint = Color(0xFF959494),
                              modifier = Modifier.padding(start = 2.dp))
                          Text(
                              text = "Schäferhunde",
                              fontWeight = FontWeight.Medium,
                              color = Color(0xFF959494))
                        }
                      }
                }
              }
          // Angaben zur Praxis (in der Arzt-Info-Card) //
          Column(horizontalAlignment = Alignment.Start) {
            Row {
              Icon(
                  Icons.Rounded.Star,
                  contentDescription = "Star Placeholder Icon",
                  tint = Color(0xFF959494),
                  modifier = Modifier.padding(start = 2.dp))
              Text(
                  text = "Kleintierpraxis Mustermann",
                  fontWeight = FontWeight.SemiBold,
                  color = Color(0xFF959494))
            }
            Row {
              Icon(
                  Icons.Rounded.Place,
                  contentDescription = "Map-Pin Icon",
                  tint = Color(0xFF959494),
                  modifier = Modifier.padding(start = 2.dp))
              Text(
                  text = "Fantasiestraße 4, Fantasiestadt",
                  fontWeight = FontWeight.Medium,
                  color = Color(0xFF959494))
            }
            Row {
              Icon(
                  Icons.Rounded.Star,
                  contentDescription = "Distance Icon",
                  tint = Color(0xFF959494),
                  modifier = Modifier.padding(start = 2.dp))
              Text(text = "10,4km", fontWeight = FontWeight.Medium, color = Color(0xFF959494))
            }
          }
        }

    // Column: Rating Arzt //
    Column(modifier = BoxModifier.background(Color.White)) {

      // Rating Diagnose
      Text(text = "Diagnose", fontWeight = FontWeight.Medium, color = Color(0xFF959494))
      Row() {
        Icon(
            Icons.Rounded.Star,
            contentDescription = "Star Placeholder Icon",
            tint = Color(0xFF00D47B),
            modifier = StarIconModifier)
        Icon(
            Icons.Rounded.Star,
            contentDescription = "Star Placeholder Icon",
            tint = Color(0xFF00D47B),
            modifier = StarIconModifier)
        Icon(
            Icons.Rounded.Star,
            contentDescription = "Star Placeholder Icon",
            tint = Color(0xFF00D47B),
            modifier = StarIconModifier)
        Icon(
            Icons.Rounded.Star,
            contentDescription = "Star Placeholder Icon",
            tint = Color(0xFF00D47B),
            modifier = StarIconModifier)
        Icon(
            Icons.Rounded.Star,
            contentDescription = "Star Placeholder Icon",
            tint = Color(0xFF00D47B),
            modifier = StarIconModifier)
      }
      // Rating Behandlung
      Text(text = "Behandlung", fontWeight = FontWeight.Medium, color = Color(0xFF959494))
      Row() {
        Icon(
            Icons.Rounded.Star,
            contentDescription = "Star Placeholder Icon",
            tint = Color(0xFF00D47B),
            modifier = StarIconModifier)
        Icon(
            Icons.Rounded.Star,
            contentDescription = "Star Placeholder Icon",
            tint = Color(0xFF00D47B),
            modifier = StarIconModifier)
        Icon(
            Icons.Rounded.Star,
            contentDescription = "Star Placeholder Icon",
            tint = Color(0xFF00D47B),
            modifier = StarIconModifier)
        Icon(
            Icons.Rounded.Star,
            contentDescription = "Star Placeholder Icon",
            tint = Color(0xFF00D47B),
            modifier = StarIconModifier)
        Icon(
            Icons.Rounded.Star,
            contentDescription = "Star Placeholder Icon",
            tint = Color(0xFF00D47B),
            modifier = StarIconModifier)
      }

      // Rating Aufklärung

      // Rating Vertrauensverhältnis
      Text(text = "Vertrauensverhältnis", fontWeight = FontWeight.Medium, color = Color(0xFF959494))
      Row() {
        Icon(
            Icons.Rounded.Star,
            contentDescription = "Star Placeholder Icon",
            tint = Color(0xFF00D47B),
            modifier = StarIconModifier)
        Icon(
            Icons.Rounded.Star,
            contentDescription = "Star Placeholder Icon",
            tint = Color(0xFF00D47B),
            modifier = StarIconModifier)
        Icon(
            Icons.Rounded.Star,
            contentDescription = "Star Placeholder Icon",
            tint = Color(0xFF00D47B),
            modifier = StarIconModifier)
        Icon(
            Icons.Rounded.Star,
            contentDescription = "Star Placeholder Icon",
            tint = Color(0xFF00D47B),
            modifier = StarIconModifier)
        Icon(
            Icons.Rounded.Star,
            contentDescription = "Star Placeholder Icon",
            tint = Color(0xFF00D47B),
            modifier = StarIconModifier)
      }

      // Rating investierte Zeit

      // Rating Freundlichkeit

      // Textfeld - Rating Arzt

      val rating = remember { mutableStateOf("") }
      TextField(
          value = rating.value,
          onValueChange = { rating.value = it },
          modifier = BoxModifier.background(Color.LightGray),
          label = { Text("Feedback") })
    }
  }

  // Abschnitt: Bewertung Praxis
  Column() {

    // Info-Card Praxis

    // Column: Rating Praxis
    // Row: Rating categories
    // Kategorien: Erlebnis (Terminvergabe, Wartezeit, ...)

    // Row: Textfeld

  }

  // Abschnitt Tierprofil-Auswahl
  // Column: Tierprofil (Auswahl, wenn mehr als ein Tierprofil existiert; drop-down?)

  // Absenden-Button

}

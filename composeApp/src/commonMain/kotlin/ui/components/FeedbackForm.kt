package ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowDropDown
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Place
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import pawsitive.composeapp.generated.resources.gecko
import pawsitive.composeapp.generated.resources.mockimage
import pawsitive.composeapp.generated.resources.praxis
import ui.theme.ProfilePictureModifier
import ui.theme.greenTextColor
import ui.theme.lightText
import ui.theme.secondaryButtonColor
import ui.theme.starNotSelectedColor
import ui.theme.subHeadingColor
import ui.theme.textFieldColor

// aus ListEntry.kt + abgeändert
val BoxModifier =
    Modifier.padding(start = 10.dp, end = 10.dp, top = 15.dp, bottom = 15.dp)
        .clip(RoundedCornerShape(Dp(15f)))
        .shadow(elevation = Dp(20f), spotColor = Color(0xff3a3a3a))
        .background(Color.White)
        .fillMaxWidth()

// aus ListEntry.kt + abgeändert
val StarIconModifier = Modifier.size(24.dp)

val TextFieldModifier = Modifier.fillMaxWidth()

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeedbackComponent() {
  Column(modifier = Modifier.verticalScroll(rememberScrollState())) {

    // Column Bewertung Arzt
    Column() {

      // Info-Card Arzt -> abgeänderte ListEntryComponent()
      Column(
          modifier = BoxModifier.padding(start = 10.dp, end = 10.dp, top = 10.dp, bottom = 10.dp)) {
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
                        modifier = Modifier.padding(start = 10.dp)) {
                          Text(
                              text = "Rita Strauß",
                              fontSize = 18.sp,
                              fontWeight = FontWeight.Bold,
                              color = Color(0xFF202020))
                          Row(modifier = Modifier.padding(top = 2.dp)) {
                            Icon(
                                Icons.Rounded.Star,
                                contentDescription = "Placeholder Icon",
                                tint = Color(0xFF959494),
                                // modifier = Modifier.padding(start = 2.dp)
                            )
                            Text(
                                text = "Schäferhunde",
                                fontWeight = FontWeight.Medium,
                                color = Color(0xFF959494))
                          }
                        }
                  }
                }
            // Angaben zur Praxis (in der Arzt-Info-Card) //
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.padding(top = 7.dp) // padding ergänzt
                ) {
                  Row {
                    Icon(
                        Icons.Rounded.Home,
                        contentDescription = "Placeholder Icon",
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
                        contentDescription = "Placeholder Distance Icon",
                        tint = Color(0xFF959494),
                        modifier = Modifier.padding(start = 2.dp))
                    Text(text = "10,4km", fontWeight = FontWeight.Medium, color = Color(0xFF959494))
                  }
                }
          }

      // Column: Rating Arzt //
      Column(
          modifier =
              BoxModifier.background(Color.White)
                  .padding(start = 10.dp, end = 10.dp, top = 15.dp, bottom = 15.dp)) {

            // Rating Diagnose
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
              Text(text = "Diagnose", fontWeight = FontWeight.Medium, color = Color(0xFF959494))
              Row(
                  verticalAlignment = Alignment.CenterVertically,
                  horizontalArrangement = Arrangement.SpaceBetween,
              ) {
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = "Star Placeholder Icon",
                    tint = starNotSelectedColor,
                    modifier = StarIconModifier)
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = "Star Placeholder Icon",
                    tint = starNotSelectedColor,
                    modifier = StarIconModifier)
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = "Star Placeholder Icon",
                    tint = starNotSelectedColor,
                    modifier = StarIconModifier)
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = "Star Placeholder Icon",
                    tint = starNotSelectedColor,
                    modifier = StarIconModifier)
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = "Star Placeholder Icon",
                    tint = starNotSelectedColor,
                    modifier = StarIconModifier)
              }
            }
            /// Rating Behandlung
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
              Text(text = "Behandlung", fontWeight = FontWeight.Medium, color = Color(0xFF959494))
              Row(
                  verticalAlignment = Alignment.CenterVertically,
                  horizontalArrangement = Arrangement.SpaceBetween,
              ) {
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = "Star Placeholder Icon",
                    tint = starNotSelectedColor,
                    modifier = StarIconModifier)
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = "Star Placeholder Icon",
                    tint = starNotSelectedColor,
                    modifier = StarIconModifier)
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = "Star Placeholder Icon",
                    tint = starNotSelectedColor,
                    modifier = StarIconModifier)
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = "Star Placeholder Icon",
                    tint = starNotSelectedColor,
                    modifier = StarIconModifier)
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = "Star Placeholder Icon",
                    tint = starNotSelectedColor,
                    modifier = StarIconModifier)
              }
            }

            /// Rating Aufklärung
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
              Text(text = "Aufklärung", fontWeight = FontWeight.Medium, color = Color(0xFF959494))
              Row() {
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = "Star Placeholder Icon",
                    tint = starNotSelectedColor,
                    modifier = StarIconModifier)
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = "Star Placeholder Icon",
                    tint = starNotSelectedColor,
                    modifier = StarIconModifier)
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = "Star Placeholder Icon",
                    tint = starNotSelectedColor,
                    modifier = StarIconModifier)
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = "Star Placeholder Icon",
                    tint = starNotSelectedColor,
                    modifier = StarIconModifier)
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = "Star Placeholder Icon",
                    tint = starNotSelectedColor,
                    modifier = StarIconModifier)
              }
            }

            /// Rating Vertrauensverhältnis
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
              Text(
                  text = "Vertrauensverhältnis",
                  fontWeight = FontWeight.Medium,
                  color = Color(0xFF959494))
              Row() {
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = "Star Placeholder Icon",
                    tint = starNotSelectedColor,
                    modifier = StarIconModifier)
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = "Star Placeholder Icon",
                    tint = starNotSelectedColor,
                    modifier = StarIconModifier)
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = "Star Placeholder Icon",
                    tint = starNotSelectedColor,
                    modifier = StarIconModifier)
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = "Star Placeholder Icon",
                    tint = starNotSelectedColor,
                    modifier = StarIconModifier)
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = "Star Placeholder Icon",
                    tint = starNotSelectedColor,
                    modifier = StarIconModifier)
              }
            }

            /// Rating investierte Zeit
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
              Text(
                  text = "Investierte Zeit",
                  fontWeight = FontWeight.Medium,
                  color = Color(0xFF959494))
              Row() {
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = "Star Placeholder Icon",
                    tint = starNotSelectedColor,
                    modifier = StarIconModifier)
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = "Star Placeholder Icon",
                    tint = starNotSelectedColor,
                    modifier = StarIconModifier)
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = "Star Placeholder Icon",
                    tint = starNotSelectedColor,
                    modifier = StarIconModifier)
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = "Star Placeholder Icon",
                    tint = starNotSelectedColor,
                    modifier = StarIconModifier)
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = "Star Placeholder Icon",
                    tint = starNotSelectedColor,
                    modifier = StarIconModifier)
              }
            }
            /// Rating Freundlichkeit
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
              Text(
                  text = "Freundlichkeit",
                  fontWeight = FontWeight.Medium,
                  color = Color(0xFF959494))
              Row() {
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = "Star Placeholder Icon",
                    tint = starNotSelectedColor,
                    modifier = StarIconModifier)
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = "Star Placeholder Icon",
                    tint = starNotSelectedColor,
                    modifier = StarIconModifier)
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = "Star Placeholder Icon",
                    tint = starNotSelectedColor,
                    modifier = StarIconModifier)
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = "Star Placeholder Icon",
                    tint = starNotSelectedColor,
                    modifier = StarIconModifier)
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = "Star Placeholder Icon",
                    tint = starNotSelectedColor,
                    modifier = StarIconModifier)
              }
            }

            //// Textfeld - Rating Arzt ////
            val rating = remember { mutableStateOf("") }

            Column() {
              TextField(
                  value = rating.value,
                  onValueChange = { rating.value = it },
                  modifier = TextFieldModifier,
                  label = { Text("Feedback") })
            }
          }
    }

    /////// Abschnitt: Bewertung Praxis ///////
    Column() {

      // Info-Card Praxis
      Column(
          modifier = BoxModifier.padding(start = 10.dp, end = 10.dp, top = 15.dp, bottom = 15.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()) {
                  // Name + Bild
                  Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(Res.drawable.praxis),
                        contentDescription = "MockImage",
                        contentScale = ContentScale.Crop,
                        modifier = ProfilePictureModifier)

                    Column(
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(start = 5.dp)) {
                          Text(
                              text = "Kleintierpraxis Tatze",
                              fontSize = 18.sp,
                              fontWeight = FontWeight.Bold,
                              color = Color(0xFF202020))
                        }
                  }
                }
            // Angaben zur Praxis (in der Arzt-Info-Card) //
            Column(horizontalAlignment = Alignment.Start, modifier = Modifier.padding(top = 7.dp)) {
              Row {
                Icon(
                    Icons.Rounded.DateRange,
                    contentDescription = "Placeholder Info Icon",
                    tint = Color(0xFF959494),
                    modifier = Modifier.padding(start = 2.dp))
                Text(
                    text = "Öffnungszeiten:",
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF959494))
              }
              // Öffnungszeiten Mo-Fr. usw
              Column(modifier = Modifier.padding(start = 25.dp, bottom = 5.dp)) {
                Text(
                    text = "Mo-Fr: 8-13Uhr",
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF959494))
                Text(
                    text = "Di, Do: 15-18Uhr",
                    fontWeight = FontWeight.Medium,
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

      // Column: Rating Praxis //
      Column(
          modifier =
              BoxModifier.background(Color.White)
                  .padding(start = 10.dp, end = 10.dp, top = 15.dp, bottom = 15.dp)) {

            // Rating Ausstattung (Praxis)
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
              Text(
                  text = "Ausstattung der Praxis",
                  fontWeight = FontWeight.Medium,
                  color = Color(0xFF959494))
              Row() {
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = "Star Placeholder Icon",
                    tint = starNotSelectedColor,
                    modifier = StarIconModifier)
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = "Star Placeholder Icon",
                    tint = starNotSelectedColor,
                    modifier = StarIconModifier)
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = "Star Placeholder Icon",
                    tint = starNotSelectedColor,
                    modifier = StarIconModifier)
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = "Star Placeholder Icon",
                    tint = starNotSelectedColor,
                    modifier = StarIconModifier)
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = "Star Placeholder Icon",
                    tint = starNotSelectedColor,
                    modifier = StarIconModifier)
              }
            }

            // Rating telefonische Erreichbarkeit (Prxis)
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
              Text(
                  text = "Telefonische Erreichbarkeit",
                  fontWeight = FontWeight.Medium,
                  color = Color(0xFF959494),
              )

              Row() {
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = "Star Placeholder Icon",
                    tint = starNotSelectedColor,
                    modifier = StarIconModifier)
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = "Star Placeholder Icon",
                    tint = starNotSelectedColor,
                    modifier = StarIconModifier)
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = "Star Placeholder Icon",
                    tint = starNotSelectedColor,
                    modifier = StarIconModifier)
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = "Star Placeholder Icon",
                    tint = starNotSelectedColor,
                    modifier = StarIconModifier)
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = "Star Placeholder Icon",
                    tint = starNotSelectedColor,
                    modifier = StarIconModifier)
              }
            }

            // Rating Parkmöglichkeiten (Praxis)

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
              Text(
                  text = "Parkmöglichkeiten",
                  fontWeight = FontWeight.Medium,
                  color = Color(0xFF959494))
              Row() {
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = "Star Placeholder Icon",
                    tint = starNotSelectedColor,
                    modifier = StarIconModifier)
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = "Star Placeholder Icon",
                    tint = starNotSelectedColor,
                    modifier = StarIconModifier)
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = "Star Placeholder Icon",
                    tint = starNotSelectedColor,
                    modifier = StarIconModifier)
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = "Star Placeholder Icon",
                    tint = starNotSelectedColor,
                    modifier = StarIconModifier)
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = "Star Placeholder Icon",
                    tint = starNotSelectedColor,
                    modifier = StarIconModifier)
              }
            }

            // Rating alternative Heilmethoden (vorhanden?)
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
              Text(
                  text = "Alternative Heilmethoden",
                  fontWeight = FontWeight.Medium,
                  color = Color(0xFF959494),
              )

              Row() {
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = "Star Placeholder Icon",
                    tint = starNotSelectedColor,
                    modifier = StarIconModifier)
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = "Star Placeholder Icon",
                    tint = starNotSelectedColor,
                    modifier = StarIconModifier)
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = "Star Placeholder Icon",
                    tint = starNotSelectedColor,
                    modifier = StarIconModifier)
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = "Star Placeholder Icon",
                    tint = starNotSelectedColor,
                    modifier = StarIconModifier)
                Icon(
                    Icons.Rounded.Star,
                    contentDescription = "Star Placeholder Icon",
                    tint = starNotSelectedColor,
                    modifier = StarIconModifier)
              }
            }

            // Rating Freundlichkeit

            // Textfeld - Rating Arzt

            val rating = remember { mutableStateOf("") }
            // NEU!!!
            OutlinedTextField(
                value = rating.value,
                onValueChange = { rating.value = it },
                modifier = TextFieldModifier,
                label = { Text("Feedback...") },
                // colors = OutlinedTextFieldDefaults.colors(textFieldColor),
                colors =
                    TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedLabelColor = textFieldColor,
                        focusedLabelColor = greenTextColor,
                        unfocusedBorderColor = textFieldColor,
                        focusedBorderColor = greenTextColor,
                    ),
            )
            // alt (zum Vergleich)
            TextField(
                value = rating.value,
                onValueChange = { rating.value = it },
                modifier = TextFieldModifier,
                label = { Text("Feedback") },
            )
          }
    }

    // Column: Tierprofil (Auswahl, wenn mehr als ein Tierprofil existiert; drop-down?)

    Row(modifier = Modifier.padding(start = 22.dp)) {
      Image(
          painter = painterResource(Res.drawable.gecko),
          contentDescription = "MockImagePetProfile",
          contentScale = ContentScale.Crop,
          modifier = ProfilePictureModifier)
      Row(
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.SpaceBetween,
          modifier = Modifier.fillMaxWidth().padding(end = 25.dp)) {
            Text(
                text = "Fridolin",
                color = subHeadingColor,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 5.dp),
            )
            Button(
                onClick = { /* Auswahlmöglichkeit PetProfile ergänzen*/ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                // shape = CircleShape,//RoundedCornerShape(Dp(20f)),

            ) {
              Icon(
                  Icons.Rounded.ArrowDropDown,
                  contentDescription = "Arrow Drop Down Icon",
                  tint = lightText,
                  modifier =
                      Modifier.clip(RoundedCornerShape(Dp(15f))).background(secondaryButtonColor))
            }
          }
    }

    // Button (Feeedback absenden)
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth().padding(start = 25.dp, end = 25.dp, top = 20.dp)) {
          FilledTonalButton(
              onClick = { /* .... */ },
              modifier = Modifier.fillMaxWidth(),
          ) {
            Text("senden")
          }
        }
  }
}

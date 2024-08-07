package ui.components

import PetProfileDropdown
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material.icons.rounded.NearMe
import androidx.compose.material.icons.rounded.Place
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import org.jetbrains.compose.resources.painterResource
import pawsitive.composeapp.generated.resources.Res
import pawsitive.composeapp.generated.resources.praxis
import ui.theme.PraxisCardModifier
import ui.theme.ProfilePictureModifier
import ui.theme.greenTextColor
import ui.theme.lightText
import ui.theme.secondaryIconColor
import ui.theme.textFieldColor

// aus ListEntry.kt + abgeändert
val StarIconModifier = Modifier.size(24.dp)

val TextFieldModifier = Modifier.fillMaxWidth()

@Composable
fun FeedbackComponent(navController: NavController) {
  Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
    VetCardComponent()

    VetRatingComponent()

    /////// Abschnitt: Bewertung Praxis ///////

    Column() {

      ////// Praxis Info-Card //////
      Column(
          modifier =
              PraxisCardModifier.padding(start = 10.dp, end = 10.dp, top = 15.dp, bottom = 15.dp),
      ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth(),
        ) {
          // PraxisBild + Name
          Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(Res.drawable.praxis),
                contentDescription = "MockImage",
                contentScale = ContentScale.Crop,
                modifier = ProfilePictureModifier,
            )
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(start = 5.dp),
            ) {
              Text(
                  modifier = Modifier.padding(start = 5.dp),
                  text = "Kleintierpraxis Tatze",
                  fontSize = 20.sp,
                  fontWeight = FontWeight.Bold,
                  color = secondaryIconColor,
              )
              // Adresse
              Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    Icons.Rounded.Place,
                    contentDescription = "Map-Pin Icon",
                    tint = secondaryIconColor,
                    modifier = Modifier.padding(start = 2.dp),
                )
                Text(
                    text = "Fantasiestraße 4, Basel",
                    fontWeight = FontWeight.Medium,
                    color = secondaryIconColor,
                )
              }
            }
          }
        }
        // weitere Angaben zur Praxis (in der Praxis-Info-Card) //
        Column(horizontalAlignment = Alignment.Start, modifier = Modifier.padding(top = 7.dp)) {

          // Öffnungszeiten
          Row {
            Icon(
                Icons.Rounded.DateRange,
                contentDescription = "Calender Icon",
                tint = secondaryIconColor,
                modifier = Modifier.padding(start = 2.dp),
            )
            Column {
              Text(
                  text = "Öffnungszeiten",
                  fontWeight = FontWeight.Medium,
                  color = secondaryIconColor,
              )
              Text(
                  text = "Mo-Fr: 8-13Uhr",
                  fontWeight = FontWeight.Medium,
                  color = secondaryIconColor,
              )
              Text(
                  text = "Di, Do: 15-18Uhr",
                  fontWeight = FontWeight.Medium,
                  color = secondaryIconColor,
              )
            }
          }

          // Entfernung
          Row {
            Icon(
                Icons.Rounded.NearMe,
                contentDescription = "Distance Icon",
                tint = secondaryIconColor,
                modifier = Modifier.padding(start = 2.dp),
            )
            Text(
                text = "10,4km",
                fontWeight = FontWeight.Medium,
                color = secondaryIconColor,
            )
          }
        }
      }

      //// Praxis Rating-Section ////
      Column(modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)) {

        // Rating Ausstattung (Praxis)
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
          Text(text = "Ausstattung der Praxis", fontWeight = FontWeight.Medium, color = lightText)
          Row(
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.SpaceBetween,
          ) {

            // Startanzeige - 0 Sterne ausgewählt
            var rating_1 by remember { mutableDoubleStateOf(0.0) }

            // Reihe mit 5 auswählbaren Sternen
            StarRow(modifier = Modifier, rating = rating_1) { rating_1 = it }
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
              color = lightText,
          )
          Row(
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.SpaceBetween,
          ) {

            // Startanzeige - 0 Sterne ausgewählt
            var rating_1 by remember { mutableDoubleStateOf(0.0) }

            // Reihe mit 5 auswählbaren Sternen
            StarRow(modifier = Modifier, rating = rating_1) { rating_1 = it }
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
              color = lightText,
          )
          Row(
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.SpaceBetween,
          ) {

            // Startanzeige - 0 Sterne ausgewählt
            var rating_1 by remember { mutableDoubleStateOf(0.0) }
            // Reihe mit 5 auswählbaren Sternen
            StarRow(modifier = Modifier, rating = rating_1) { rating_1 = it }
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
              color = lightText,
          )
          Row(
              // modifier = Modifier.fillMaxSize(),
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.SpaceBetween,
          ) {

            // Startanzeige - 0 Sterne ausgewählt
            var rating_1 by remember { mutableDoubleStateOf(0.0) }

            // Reihe mit 5 auswählbaren Sternen
            StarRow(modifier = Modifier, rating = rating_1) { rating_1 = it }
          }
        }

        /// Textfeld - Rating Praxis //

        val rating = remember { mutableStateOf("") }
        OutlinedTextField(
            value = rating.value,
            onValueChange = { rating.value = it },
            modifier = TextFieldModifier,
            label = { Text("Feedback...") },
            colors =
                OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = greenTextColor,
                    unfocusedBorderColor = textFieldColor,
                    focusedLabelColor = greenTextColor,
                    unfocusedLabelColor = textFieldColor,
                ),
        )
      }
    }

    ///// HIER SOLL DAS DROP DOWN HIN
    PetProfileDropdown()

    // Button (Feedback absenden)
    Row(
        modifier = Modifier.fillMaxWidth().padding(20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
      Button(
          onClick = { navController.navigate(Screen.Completed.name) },
          modifier = Modifier.fillMaxWidth(),
      ) {
        Text("Senden")
      }
    }
  }
}

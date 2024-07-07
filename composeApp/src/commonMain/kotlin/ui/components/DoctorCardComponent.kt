package ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material.icons.rounded.NearMe
import androidx.compose.material.icons.rounded.Pets
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import pawsitive.composeapp.generated.resources.Res
import pawsitive.composeapp.generated.resources.mockimage
import ui.theme.ProfileCardModifier
import ui.theme.ProfilePictureModifierLG
import ui.theme.iconColorLight
import ui.theme.subHeadingColor


@Composable
fun DoctorCardComponent(){
  // Info-Card Arzt -> abgeänderte ListEntryComponent()
    Column(
      modifier = ProfileCardModifier
        .padding(start = 10.dp, end = 10.dp, top = 10.dp, bottom = 10.dp)
      
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
            modifier = ProfilePictureModifierLG)

          Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(start = 8.dp)) {
            Text(
              modifier = Modifier.padding(start = 5.dp),
              text = "Rita Strauß",
              fontSize = 20.sp,
              fontWeight = FontWeight.Bold,
              color = subHeadingColor)
            Row(modifier = Modifier.padding(start = 2.dp, top = 2.dp)) {
              Icon(
                Icons.Rounded.Pets,
                contentDescription = "Placeholder Icon",
                tint = iconColorLight,
                // modifier = Modifier.padding(start = 2.dp)
              )
              Text(
                text = "Schäferhunde",
                fontWeight = FontWeight.Medium,
                color = iconColorLight)
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
            tint = iconColorLight,
            modifier = Modifier.padding(start = 2.dp))
          Text(
            text = "Kleintierpraxis Tatze",
            fontWeight = FontWeight.SemiBold,
            color = iconColorLight)
        }
        Row {
          Icon(
            Icons.Rounded.LocationOn,
            contentDescription = "Map-Pin Icon",
            tint = iconColorLight,
            modifier = Modifier.padding(start = 2.dp))
          Text(
            text = "Fantasiestraße 4, Fantasiestadt",
            fontWeight = FontWeight.Medium,
            color = iconColorLight)
        }
        Row {
          Icon(
            Icons.Rounded.NearMe,
            contentDescription = "Distance Icon",
            tint = iconColorLight,
            modifier = Modifier.padding(start = 2.dp))
          Text(text = "10,4km", fontWeight = FontWeight.Medium, color = iconColorLight)
        }
      }
    }
}

  

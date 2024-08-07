package ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material.icons.rounded.NearMe
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Place
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import coil3.compose.LocalPlatformContext
import coil3.request.ImageRequest
import coil3.request.crossfade
import extensions.format
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import pawsitive.composeapp.generated.resources.Map
import pawsitive.composeapp.generated.resources.Res
import pawsitive.composeapp.generated.resources.and
import pawsitive.composeapp.generated.resources.clinic_placeholder
import pawsitive.composeapp.generated.resources.pet_placeholder
import pawsitive.composeapp.generated.resources.vets
import ui.components.ListEntryComponent
import ui.theme.HeaderImageModifier
import ui.theme.ProfilePictureModifierSM
import ui.theme.StarModifier
import ui.theme.iconColor
import ui.theme.lightText
import ui.theme.starSelectedColor
import ui.theme.subHeadingColor

@Composable
@Preview
fun ClinicScreen(navController: NavController, clinicId: String) {
  val state = rememberScrollState()
  val viewModel = viewModel { ClinicViewModel() }
  val uiState by viewModel.uiState.collectAsState()
  LaunchedEffect(true) { viewModel.loadClinic(clinicId) }
  // gesammte Ansicht
  Column(modifier = Modifier.verticalScroll(state)) {
    // Header Image
    AsyncImage(
        model =
            ImageRequest.Builder(LocalPlatformContext.current)
                .data(uiState.imageUrl)
                .crossfade(true)
                .build(),
        contentDescription = null,
        modifier = HeaderImageModifier.aspectRatio(1.5f),
        contentScale = ContentScale.Crop,
        placeholder = painterResource(Res.drawable.clinic_placeholder),
        error = painterResource(Res.drawable.clinic_placeholder),
    )

    val clinic = uiState.clinic
    if (clinic == null) {
      CircularProgressIndicator(
          modifier = Modifier.align(Alignment.CenterHorizontally).padding(24.dp),
      )
    } else {
      Column(modifier = Modifier.fillMaxWidth().background(Color.White)) {
        Column(modifier = Modifier.padding(top = 8.dp, start = 10.dp).fillMaxWidth()) {
          // Clinic Name
          Text(
              text = clinic.name,
              fontWeight = FontWeight.Bold,
              fontSize = 20.sp,
              color = subHeadingColor,
              modifier = Modifier.align(Alignment.Start),
          )

          Row {
            Icon(
                Icons.Rounded.Star,
                contentDescription = "Star Placeholder Icon",
                tint = starSelectedColor,
                modifier = StarModifier,
            )
            Icon(
                Icons.Rounded.Star,
                contentDescription = "Star Placeholder Icon",
                tint = starSelectedColor,
                modifier = StarModifier,
            )
            Icon(
                Icons.Rounded.Star,
                contentDescription = "Star Placeholder Icon",
                tint = starSelectedColor,
                modifier = StarModifier,
            )
            Icon(
                Icons.Rounded.Star,
                contentDescription = "Star Placeholder Icon",
                tint = starSelectedColor,
                modifier = StarModifier,
            )
            Icon(
                Icons.Rounded.Star,
                contentDescription = "Star Placeholder Icon",
                tint = starSelectedColor,
                modifier = StarModifier,
            )
            Text(
                text = clinic.averageRating.format(),
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF202020),
            )
          }
        }

        // Additional Information (zur Praxis)
        Column(modifier = Modifier.fillMaxWidth().padding(10.dp)) {
          Row(
              verticalAlignment = Alignment.CenterVertically,
              modifier = Modifier.fillMaxWidth(),
          ) {
            Icon(
                Icons.Rounded.DateRange,
                contentDescription = "Calender Icon",
                tint = iconColor,
                modifier = Modifier.padding(start = 2.dp),
            )
            Text(text = "Öffnungszeiten:", fontWeight = FontWeight.SemiBold, color = lightText)
          }

          // Öffnungszeiten Mo-Fr. usw
          Column(modifier = Modifier.padding(start = 26.dp, bottom = 5.dp)) {
            Text(text = clinic.openingHours, fontWeight = FontWeight.Medium, color = lightText)
          }
          Row(
              modifier = Modifier.padding(top = 2.dp),
              verticalAlignment = Alignment.CenterVertically,
          ) {
            Icon(
                Icons.Rounded.Place,
                contentDescription = "MapPin Icon",
                tint = iconColor,
            )
            Text(
                text = clinic.streetAndHouseNumber,
                fontWeight = FontWeight.Medium,
                color = lightText,
            )
          }

          Row(
              modifier = Modifier.padding(top = 2.dp),
              verticalAlignment = Alignment.CenterVertically,
          ) {
            Icon(
                Icons.Rounded.Phone,
                contentDescription = "Phone Icon",
                tint = iconColor,
            )
            Text(
                text = clinic.phone,
                fontWeight = FontWeight.Medium,
                color = lightText,
            )
          }

          Row(
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.SpaceBetween,
              modifier = Modifier.fillMaxWidth(),
          ) {
            Row(
                modifier = Modifier.padding(top = 2.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
            ) {
              Icon(
                  Icons.Rounded.NearMe,
                  contentDescription = "Distance Icon",
                  tint = iconColor,
              )
              Text(text = "2km", fontWeight = FontWeight.Medium, color = lightText)
            }
          }
        }
      }

      Text(
          stringResource(Res.string.vets),
          modifier = Modifier.padding(10.dp, 10.dp, 10.dp, 5.dp),
          color = subHeadingColor,
          fontSize = 18.sp,
          fontWeight = FontWeight.Bold,
      )
      clinic.vets.forEach { ListEntryComponent(navController, it) }

      // Map-Ausschnitt
      Column(modifier = Modifier.sizeIn(maxHeight = 300.dp)) {
        Text(
            text = "Map",
            modifier = Modifier.padding(10.dp, 5.dp, 10.dp, 5.dp),
            color = subHeadingColor,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
        )
        Image(
            painter = painterResource(Res.drawable.Map),
            contentDescription = "Ausschnitt Map",
            contentScale = ContentScale.Crop,
            modifier =
                Modifier.fillMaxSize()
                    .clip(RoundedCornerShape(25f))
                    .padding(horizontal = 7.dp, vertical = 5.dp),
        )
      }

      // Bewertungen
      Text(
          text = "Bewertungen",
          modifier = Modifier.padding(10.dp, 5.dp, 10.dp, 5.dp),
          color = subHeadingColor,
          fontSize = 18.sp,
          fontWeight = FontWeight.Bold,
      )
      Column(
          modifier =
              Modifier.padding(horizontal = 7.dp) // , vertical = 5.dp
                  // .clip(RoundedCornerShape(15.dp))
                  .fillMaxWidth()
                  .background(Color.White),
          horizontalAlignment = Alignment.Start,
      ) {

        //// Allgemeine Wartezeit
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp),
        ) {
          Text(
              text = "Allgemeine Wartezeit",
              color = lightText,
              fontWeight = FontWeight.SemiBold,
          )
          Row {
            Row {
              Icon(
                  Icons.Rounded.Star,
                  contentDescription = "Star Placeholder Icon",
                  tint = starSelectedColor,
                  modifier = StarModifier,
              )
            }
            Text(
                text = clinic.averageRatingWaitingTime.format(),
                fontWeight = FontWeight.SemiBold,
                color = subHeadingColor,
            )
          }
        }

        //// Ausstattung der Praxis
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp),
        ) {
          Text(
              text = "Ausstattung der Praxis",
              color = lightText,
              fontWeight = FontWeight.SemiBold,
          )
          Row {
            Row {
              Icon(
                  Icons.Rounded.Star,
                  contentDescription = "Star Placeholder Icon",
                  tint = starSelectedColor,
                  modifier = StarModifier,
              )
            }
            Text(
                text = clinic.averageRatingEquipment.format(),
                fontWeight = FontWeight.SemiBold,
                color = subHeadingColor,
            )
          }
        }

        //// Telefonische Erreichbarkeit
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp),
        ) {
          Text(
              text = "Telefonische Erreichbarkeit",
              color = lightText,
              fontWeight = FontWeight.SemiBold,
          )
          Row {
            Row {
              Icon(
                  Icons.Rounded.Star,
                  contentDescription = "Star Placeholder Icon",
                  tint = starSelectedColor,
                  modifier = StarModifier,
              )
            }
            Text(
                text = clinic.averageRatingPhoneAvailability.format(),
                fontWeight = FontWeight.SemiBold,
                color = subHeadingColor,
            )
          }
        }

        //// Parkmöglichkeit
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp),
        ) {
          Text(
              text = "Parkmöglichkeit",
              color = lightText,
              fontWeight = FontWeight.SemiBold,
          )
          Row {
            Row {
              Icon(
                  Icons.Rounded.Star,
                  contentDescription = "Star Placeholder Icon",
                  tint = starSelectedColor,
                  modifier = StarModifier,
              )
            }
            Text(
                text = clinic.averageRatingParking.format(),
                fontWeight = FontWeight.SemiBold,
                color = subHeadingColor,
            )
          }
        }

        //// Preisleistungsverhältnis
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp),
        ) {
          Text(
              text = "Preisleistungsverhältnis",
              color = lightText,
              fontWeight = FontWeight.SemiBold,
          )
          Row {
            Row {
              Icon(
                  Icons.Rounded.Star,
                  contentDescription = "Star Placeholder Icon",
                  tint = starSelectedColor,
                  modifier = StarModifier,
              )
            }
            Text(
                text = clinic.averageRatingPricePerformance.format(),
                fontWeight = FontWeight.SemiBold,
                color = subHeadingColor,
            )
          }
        }

        //// Alternative Heilmethoden
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp),
        ) {
          Text(
              text = "Alternative Heilmethoden",
              color = lightText,
              fontWeight = FontWeight.SemiBold,
          )
          Row {
            Row {
              Icon(
                  Icons.Rounded.Star,
                  contentDescription = "Star Placeholder Icon",
                  tint = starSelectedColor,
                  modifier = StarModifier,
              )
            }
            Text(
                text = clinic.averageRatingAlternativeMedicine.format(),
                fontWeight = FontWeight.SemiBold,
                color = subHeadingColor,
            )
          }
        }
      }

      clinic.ratings.forEach {
        var ratingImageUrl by remember { mutableStateOf("") }
        LaunchedEffect(true) { ratingImageUrl = it.getImageUrl() }
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.fillMaxWidth().background(Color.White).padding(top = 20.dp),
        ) {
          HorizontalDivider(thickness = 3.dp)
          Column(modifier = Modifier.padding(10.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 15.dp),
            ) {
              AsyncImage(
                  model =
                      ImageRequest.Builder(LocalPlatformContext.current)
                          .data(ratingImageUrl)
                          .crossfade(true)
                          .build(),
                  contentDescription = null,
                  modifier = ProfilePictureModifierSM,
                  contentScale = ContentScale.Crop,
                  placeholder = painterResource(Res.drawable.pet_placeholder),
                  error = painterResource(Res.drawable.pet_placeholder),
              )
              Text(
                  run {
                    val commaPets = it.pets.dropLast(1)
                    val lastPet = it.pets.last().name
                    if (commaPets.isEmpty()) {
                      lastPet
                    } else {
                      "${commaPets.joinToString { it.name }} ${stringResource(Res.string.and)} $lastPet"
                    }
                  },
                  modifier = Modifier.padding(start = 5.dp),
                  fontSize = 18.sp,
                  fontWeight = FontWeight.Bold,
                  color = subHeadingColor,
              )
            }
            Text(
                text = it.comment,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = subHeadingColor,
            )
          }
        }
      }
    }
  }
}

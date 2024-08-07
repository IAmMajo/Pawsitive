package ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.NearMe
import androidx.compose.material.icons.rounded.Pets
import androidx.compose.material.icons.rounded.Place
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import coil3.compose.LocalPlatformContext
import coil3.request.ImageRequest
import coil3.request.crossfade
import data.database.Vet
import extensions.format
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import pawsitive.composeapp.generated.resources.Res
import pawsitive.composeapp.generated.resources.and
import pawsitive.composeapp.generated.resources.pet_placeholder
import pawsitive.composeapp.generated.resources.vet_placeholder
import ui.theme.CardModifier
import ui.theme.ProfilePictureModifier
import ui.theme.ProfilePictureModifierSM
import ui.theme.StarModifier
import ui.theme.iconColor
import ui.theme.lightText
import ui.theme.subHeadingColor

@Composable
fun ListEntryComponent(navController: NavController, vet: Vet) {
  var isExpanded by remember { mutableStateOf(false) }
  var imageUrl by remember { mutableStateOf("") }
  val expandedPadding = animateDpAsState(targetValue = if (isExpanded) 15.dp else 0.dp)
  LaunchedEffect(true) { imageUrl = vet.getImageUrl() }
  Column(
      modifier =
          CardModifier.fillMaxWidth()
              .shadow(8.dp, RoundedCornerShape(8.dp))
              .background(Color.White, RoundedCornerShape(8.dp))
              .clickable { isExpanded = !isExpanded }
              .animateContentSize()
              .padding(start = 10.dp, end = 10.dp, top = 15.dp, bottom = 15.dp),
  ) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth(),
    ) {
      Row(verticalAlignment = Alignment.CenterVertically) {
        AsyncImage(
            model =
                ImageRequest.Builder(LocalPlatformContext.current)
                    .data(imageUrl)
                    .crossfade(true)
                    .build(),
            contentDescription = null,
            modifier = ProfilePictureModifier,
            contentScale = ContentScale.Crop,
            placeholder = painterResource(Res.drawable.vet_placeholder),
            error = painterResource(Res.drawable.vet_placeholder),
        )
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(start = 5.dp),
        ) {
          Text(
              text = vet.name,
              fontSize = 18.sp,
              fontWeight = FontWeight.Bold,
              color = subHeadingColor,
              modifier = Modifier.padding(start = 2.dp),
          )

          Row(
              modifier = Modifier.padding(start = 2.dp),
              verticalAlignment = Alignment.CenterVertically,
          ) {
            val rating = remember { mutableStateOf("") }
            Row {
              AverageStars(
                  rating = vet.averageRating,
                  stars = 5,
              )
            }
            Text(
                text = vet.averageRating.format(),
                fontWeight = FontWeight.SemiBold,
                color = subHeadingColor,
            )
          }
          Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
            Icon(
                Icons.Rounded.Pets,
                contentDescription = "Paw Icon",
                tint = iconColor,
                modifier = Modifier.padding(start = 2.dp),
            )
            Text(text = vet.specialization, fontWeight = FontWeight.Medium, color = lightText)
          }
        }
      }
    }

    if (isExpanded) {
      val clinic = vet.clinic
      if (clinic != null) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(top = expandedPadding.value),
        ) {
          Row {
            Icon(
                Icons.Rounded.Home,
                contentDescription = "Place Icon",
                tint = iconColor,
                modifier = Modifier.padding(start = 2.dp),
            )
            Text(
                text = clinic.name,
                fontWeight = FontWeight.SemiBold,
                color = lightText,
            )
          }
          Column() {
            Row {
              Icon(
                  Icons.Rounded.DateRange,
                  contentDescription = "Calendar Icon",
                  tint = iconColor,
                  modifier = Modifier.padding(start = 2.dp),
              )
              Text(text = "Öffnungszeiten:", fontWeight = FontWeight.SemiBold, color = lightText)
            }
            Column(modifier = Modifier.padding(start = 26.dp, bottom = 5.dp)) {
              Text(
                  text = clinic.openingHours,
                  fontWeight = FontWeight.Medium,
                  color = lightText,
              )
            }
          }
          Row {
            Icon(
                Icons.Rounded.Place,
                contentDescription = "Map-Pin Icon",
                tint = iconColor,
                modifier = Modifier.padding(start = 2.dp),
            )
            Text(
                text = clinic.shortAddress,
                fontWeight = FontWeight.Medium,
                color = lightText,
            )
          }
          Row {
            Icon(
                Icons.Rounded.NearMe,
                contentDescription = "Distance Icon",
                tint = iconColor,
                modifier = Modifier.padding(start = 2.dp),
            )
            Text(
                text = "10,4km",
                fontWeight = FontWeight.Medium,
                color = lightText,
            )
          }
        }
      }

      Column(
          horizontalAlignment = Alignment.Start,
          modifier = Modifier.fillMaxWidth().padding(top = 20.dp),
      ) {
        Text(
            text = "Bewertungen",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = subHeadingColor,
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth(),
        ) {
          Text(text = "Diagnose", color = lightText)
          Row {
            Row {
              Icon(
                  Icons.Rounded.Star,
                  contentDescription = "Star Placeholder Icon",
                  tint = Color(0xFF00D47B),
                  modifier = StarModifier,
              )
              Icon(
                  Icons.Rounded.Star,
                  contentDescription = "Star Placeholder Icon",
                  tint = Color(0xFF00D47B),
                  modifier = StarModifier,
              )
              Icon(
                  Icons.Rounded.Star,
                  contentDescription = "Star Placeholder Icon",
                  tint = Color(0xFF00D47B),
                  modifier = StarModifier,
              )
              Icon(
                  Icons.Rounded.Star,
                  contentDescription = "Star Placeholder Icon",
                  tint = Color(0xFF00D47B),
                  modifier = StarModifier,
              )
              Icon(
                  Icons.Rounded.Star,
                  contentDescription = "Star Placeholder Icon",
                  tint = Color(0xFF00D47B),
                  modifier = StarModifier,
              )
            }
            Text(
                text = vet.averageRatingDiagnosis.format(),
                fontWeight = FontWeight.SemiBold,
                color = subHeadingColor,
            )
          }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth(),
        ) {
          Text(text = "Behandlung", color = lightText)
          Row {
            Row {
              Icon(
                  Icons.Rounded.Star,
                  contentDescription = "Star Placeholder Icon",
                  tint = Color(0xFF00D47B),
                  modifier = StarModifier,
              )
              Icon(
                  Icons.Rounded.Star,
                  contentDescription = "Star Placeholder Icon",
                  tint = Color(0xFF00D47B),
                  modifier = StarModifier,
              )
              Icon(
                  Icons.Rounded.Star,
                  contentDescription = "Star Placeholder Icon",
                  tint = Color(0xFF00D47B),
                  modifier = StarModifier,
              )
              Icon(
                  Icons.Rounded.Star,
                  contentDescription = "Star Placeholder Icon",
                  tint = Color(0xFF00D47B),
                  modifier = StarModifier,
              )
              Icon(
                  Icons.Rounded.Star,
                  contentDescription = "Star Placeholder Icon",
                  tint = Color(0xFF00D47B),
                  modifier = StarModifier,
              )
            }
            Text(
                text = vet.averageRatingTreatment.format(),
                fontWeight = FontWeight.SemiBold,
                color = subHeadingColor,
            )
          }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth(),
        ) {
          Text(text = "Aufklärung", color = lightText)
          Row {
            Row {
              Icon(
                  Icons.Rounded.Star,
                  contentDescription = "Star Placeholder Icon",
                  tint = Color(0xFF00D47B),
                  modifier = StarModifier,
              )
              Icon(
                  Icons.Rounded.Star,
                  contentDescription = "Star Placeholder Icon",
                  tint = Color(0xFF00D47B),
                  modifier = StarModifier,
              )
              Icon(
                  Icons.Rounded.Star,
                  contentDescription = "Star Placeholder Icon",
                  tint = Color(0xFF00D47B),
                  modifier = StarModifier,
              )
              Icon(
                  Icons.Rounded.Star,
                  contentDescription = "Star Placeholder Icon",
                  tint = Color(0xFF00D47B),
                  modifier = StarModifier,
              )
              Icon(
                  Icons.Rounded.Star,
                  contentDescription = "Star Placeholder Icon",
                  tint = Color(0xFF00D47B),
                  modifier = StarModifier,
              )
            }
            Text(
                text = vet.averageRatingInformation.format(),
                fontWeight = FontWeight.SemiBold,
                color = subHeadingColor,
            )
          }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth(),
        ) {
          Text(text = "Vertrauensverhältnis", color = lightText)
          Row {
            Row {
              Icon(
                  Icons.Rounded.Star,
                  contentDescription = "Star Placeholder Icon",
                  tint = Color(0xFF00D47B),
                  modifier = StarModifier,
              )
              Icon(
                  Icons.Rounded.Star,
                  contentDescription = "Star Placeholder Icon",
                  tint = Color(0xFF00D47B),
                  modifier = StarModifier,
              )
              Icon(
                  Icons.Rounded.Star,
                  contentDescription = "Star Placeholder Icon",
                  tint = Color(0xFF00D47B),
                  modifier = StarModifier,
              )
              Icon(
                  Icons.Rounded.Star,
                  contentDescription = "Star Placeholder Icon",
                  tint = Color(0xFF00D47B),
                  modifier = StarModifier,
              )
              Icon(
                  Icons.Rounded.Star,
                  contentDescription = "Star Placeholder Icon",
                  tint = Color(0xFF00D47B),
                  modifier = StarModifier,
              )
            }
            Text(
                text = vet.averageRatingTrust.format(),
                fontWeight = FontWeight.SemiBold,
                color = subHeadingColor,
            )
          }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth(),
        ) {
          Text(text = "Investierte Zeit", color = lightText)
          Row {
            Row {
              Icon(
                  Icons.Rounded.Star,
                  contentDescription = "Star Placeholder Icon",
                  tint = Color(0xFF00D47B),
                  modifier = StarModifier,
              )
              Icon(
                  Icons.Rounded.Star,
                  contentDescription = "Star Placeholder Icon",
                  tint = Color(0xFF00D47B),
                  modifier = StarModifier,
              )
              Icon(
                  Icons.Rounded.Star,
                  contentDescription = "Star Placeholder Icon",
                  tint = Color(0xFF00D47B),
                  modifier = StarModifier,
              )
              Icon(
                  Icons.Rounded.Star,
                  contentDescription = "Star Placeholder Icon",
                  tint = Color(0xFF00D47B),
                  modifier = StarModifier,
              )
              Icon(
                  Icons.Rounded.Star,
                  contentDescription = "Star Placeholder Icon",
                  tint = Color(0xFF00D47B),
                  modifier = StarModifier,
              )
            }
            Text(
                text = vet.averageRatingInvestedTime.format(),
                fontWeight = FontWeight.SemiBold,
                color = subHeadingColor,
            )
          }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth(),
        ) {
          Text(text = "Freundlichkeit", color = lightText)
          Row {
            Row {
              Icon(
                  Icons.Rounded.Star,
                  contentDescription = "Star Placeholder Icon",
                  tint = Color(0xFF00D47B),
                  modifier = StarModifier,
              )
              Icon(
                  Icons.Rounded.Star,
                  contentDescription = "Star Placeholder Icon",
                  tint = Color(0xFF00D47B),
                  modifier = StarModifier,
              )
              Icon(
                  Icons.Rounded.Star,
                  contentDescription = "Star Placeholder Icon",
                  tint = Color(0xFF00D47B),
                  modifier = StarModifier,
              )
              Icon(
                  Icons.Rounded.Star,
                  contentDescription = "Star Placeholder Icon",
                  tint = Color(0xFF00D47B),
                  modifier = StarModifier,
              )
              Icon(
                  Icons.Rounded.Star,
                  contentDescription = "Star Placeholder Icon",
                  tint = Color(0xFF00D47B),
                  modifier = StarModifier,
              )
            }
            Text(
                text = vet.averageRatingFriendliness.format(),
                fontWeight = FontWeight.SemiBold,
                color = subHeadingColor,
            )
          }
        }

        vet.ratings.forEach {
          var ratingImageUrl by remember { mutableStateOf("") }
          LaunchedEffect(true) { ratingImageUrl = it.getImageUrl() }
          Column(
              horizontalAlignment = Alignment.Start,
              modifier = Modifier.fillMaxWidth().padding(top = 20.dp),
          ) {
            HorizontalDivider(
                thickness = 3.dp,
                modifier = Modifier.padding(bottom = 10.dp),
            )
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
              Column(
                  verticalArrangement = Arrangement.Center,
                  modifier = Modifier.padding(start = 5.dp),
              ) {
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
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = subHeadingColor,
                )
                Row {
                  Icon(
                      Icons.Rounded.Star,
                      contentDescription = "Star Placeholder Icon",
                      tint = Color(0xFF959494),
                      modifier = Modifier.padding(start = 2.dp),
                  )
                  Text(
                      text = "Schäferhunde",
                      fontWeight = FontWeight.Medium,
                      color = Color(0xFF959494),
                  )
                }
              }
            }
            Text(
                text = it.comment,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = subHeadingColor,
            )
          }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
        ) {
          if (clinic != null) {
            Button(
                onClick = { navController.navigate("${Screen.Clinic.name}/${clinic.id}") },
                modifier = Modifier.padding(top = 10.dp).width(160.dp),
            ) {
              Text(text = "Praxis")
            }
          }

          Button(
              onClick = { navController.navigate(Screen.Rate.name) },
              modifier = Modifier.padding(top = 10.dp).width(160.dp),
          ) {
            Text(text = "Bewerten")
          }
        }
      }
    }
  }
}

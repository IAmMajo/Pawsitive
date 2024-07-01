package ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Place
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
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
import data.database.Vet
import org.jetbrains.compose.resources.painterResource
import pawsitive.composeapp.generated.resources.Res
import pawsitive.composeapp.generated.resources.mockimage

////// VALUE SECTION ///////
val ProfilePictureModifier = Modifier.size(70.dp).clip(CircleShape)

val ProfileCommentPictureModifier = Modifier.size(35.dp).clip(CircleShape)

val ListEntryBoxModifier =
    Modifier.padding(Dp(10f)) // Eigentlich der Margin (Compose ist super weird)
        .clip(RoundedCornerShape(Dp(15f)))
        .shadow(elevation = Dp(20f), spotColor = Color(0xff3a3a3a))
        .background(Color.White)

val StarModifier = Modifier.size(24.dp)

val ButtonModifier =
    Modifier.background(color = Color(0xFF00D47B)).clip(RoundedCornerShape(Dp(20f)))

////// COMPOSABLE SECTION ///////

@Composable
fun ListEntryComponent(vet: Vet) {
  var isExpanded by remember { mutableStateOf(false) }
  val expandedPadding = animateDpAsState(targetValue = if (isExpanded) 15.dp else 0.dp)

  Column(
      modifier =
          ListEntryBoxModifier.fillMaxWidth()
              .clickable { isExpanded = !isExpanded }
              .animateContentSize()
              .padding(start = 10.dp, end = 10.dp, top = 15.dp, bottom = 15.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()) {
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
                          text = vet.name,
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
                            text = vet.specialization,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFF959494))
                      }
                    }
              }

              Row {
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
                }
                Text(
                    text = vet.averageRating,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF202020),
                )
              }
            }

        if (isExpanded) {
          val clinic = vet.clinic!!
          Column(
              horizontalAlignment = Alignment.Start,
              modifier = Modifier.padding(top = expandedPadding.value)) {
                Row {
                  Icon(
                      Icons.Rounded.Star,
                      contentDescription = "Star Placeholder Icon",
                      tint = Color(0xFF959494),
                      modifier = Modifier.padding(start = 2.dp))
                  Text(
                      text = clinic.name,
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
                      text = clinic.shortAddress,
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

          Column(
              horizontalAlignment = Alignment.Start,
              modifier = Modifier.fillMaxWidth().padding(top = 20.dp)) {
                Text(
                    text = "Bewertungen",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF202020))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()) {
                      Text(text = "Diagnose")
                      Row {
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
                        }
                        Text(
                            text = vet.diagnosisRatingsAmount.toString(),
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF202020))
                      }
                    }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()) {
                      Text(text = "Behandlung")
                      Row {
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
                        }
                        Text(
                            text = vet.empathyRatingsAmount.toString(),
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF202020))
                      }
                    }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()) {
                      Text(text = "Empathie")
                      Row {
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
                        }
                        Text(
                            text = vet.empathyRatingsAmount.toString(),
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF202020))
                      }
                    }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()) {
                      Text(text = "Freundlichkeit")
                      Row {
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
                        }
                        Text(
                            text = "34",
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF202020))
                      }
                    }

                vet.ratings.forEach {
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
                      Image(
                          painter = painterResource(Res.drawable.mockimage),
                          contentDescription = "MockImage",
                          contentScale = ContentScale.Crop,
                          modifier = ProfileCommentPictureModifier,
                      )
                      Column(
                          verticalArrangement = Arrangement.Center,
                          modifier = Modifier.padding(start = 5.dp),
                      ) {
                        Text(
                            text = "Peter Strauß",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF202020),
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
                        color = Color(0xFF202020),
                    )
                  }
                }
              }
        }
      }
}

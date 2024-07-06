package ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
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
import data.database.Vet
import extensions.format
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import pawsitive.composeapp.generated.resources.Res
import pawsitive.composeapp.generated.resources.and
import pawsitive.composeapp.generated.resources.mockimage
import ui.theme.CardModifier
import ui.theme.ProfilePictureModifier
import ui.theme.ProfilePictureModifierSM
import ui.theme.StarModifier

@Composable
fun ListEntryComponent(vet: Vet, navController: NavController) {
  
  var isExpanded by remember { mutableStateOf(false) }
  val expandedPadding = animateDpAsState(targetValue = if (isExpanded) 15.dp else 0.dp)

  Column(
      modifier =
          CardModifier.fillMaxWidth()
              .shadow(8.dp, RoundedCornerShape(8.dp))
              .background(Color.White, RoundedCornerShape(8.dp))
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
                          color = Color(0xFF202020),
                          modifier = Modifier.padding(start = 5.dp))

                      Row(modifier = Modifier.padding(start = 3.dp)) {
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
                            text = vet.averageRating.format(),
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF202020),
                        )
                      }
                      Row {
                        Icon(
                            Icons.Rounded.Star,
                            contentDescription = "Star Placeholder Icon",
                            tint = Color(0xffb9b9b9),
                            modifier = Modifier.padding(start = 2.dp))
                        Text(
                            text = vet.specialization,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xffb9b9b9))
                      }
                    }
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
                      tint = Color(0xffb9b9b9),
                      modifier = Modifier.padding(start = 2.dp))
                  Text(
                      text = clinic.name,
                      fontWeight = FontWeight.SemiBold,
                      color = Color(0xffb9b9b9))
                }
                Row {
                  Icon(
                      Icons.Rounded.Place,
                      contentDescription = "Map-Pin Icon",
                      tint = Color(0xffb9b9b9),
                      modifier = Modifier.padding(start = 2.dp))
                  Text(
                      text = clinic.shortAddress,
                      fontWeight = FontWeight.Medium,
                      color = Color(0xffb9b9b9))
                }
                Row {
                  Icon(
                      Icons.Rounded.Star,
                      contentDescription = "Distance Icon",
                      tint = Color(0xffb9b9b9),
                      modifier = Modifier.padding(start = 2.dp))
                  Text(text = "10,4km", fontWeight = FontWeight.Medium, color = Color(0xffb9b9b9))
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
                    modifier = Modifier.fillMaxWidth(),
                ) {
                  Text(text = "Diagnose")
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
                        color = Color(0xFF202020),
                    )
                  }
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth(),
                ) {
                  Text(text = "Behandlung")
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
                        color = Color(0xFF202020),
                    )
                  }
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth(),
                ) {
                  Text(text = "Aufklärung")
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
                        color = Color(0xFF202020),
                    )
                  }
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth(),
                ) {
                  Text(text = "Vertrauensverhältnis")
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
                        color = Color(0xFF202020),
                    )
                  }
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth(),
                ) {
                  Text(text = "Investierte Zeit")
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
                        color = Color(0xFF202020),
                    )
                  }
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth(),
                ) {
                  Text(text = "Freundlichkeit")
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
                        color = Color(0xFF202020),
                    )
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
                          modifier = ProfilePictureModifierSM,
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
              
                Button(
                  onClick = {
                    navController.navigate(Screen.Praxis.name)
                  },
                  modifier = Modifier.padding(top = 10.dp)
                ){
                  Text(text = "Praxis")
                }
            
              }
          
          
        }
      }
}

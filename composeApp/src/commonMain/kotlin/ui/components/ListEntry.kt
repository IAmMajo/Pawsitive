package ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Place
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import pawsitive.composeapp.generated.resources.Res
import pawsitive.composeapp.generated.resources.mockimage
import pawsitive.composeapp.generated.resources.hundewelpe
import pawsitive.composeapp.generated.resources.gecko
import pawsitive.composeapp.generated.resources.pfau


import androidx.compose.ui.unit.sp


////// VALUE SECTION ///////
val ProfilePictureModifier = Modifier
    .size(70.dp)
    .clip(CircleShape)

val ProfileCommentIctureModifier = Modifier
    .size(35.dp)
    .clip(CircleShape)

val ListEntryBoxModifier = Modifier
    .padding(Dp(10f)) // Eigentlich der Margin (Compose ist super weird)
    .clip(RoundedCornerShape(Dp(15f)))
    .shadow(elevation = Dp(20f), spotColor = Color(0xff3a3a3a))
    .background(Color.White)

val StarModifier = Modifier
    .size(24.dp)

val ButtonModifier = Modifier
    .background(color = Color(0xFF00D47B))
    .clip(RoundedCornerShape(Dp(20f)))

////// COMPOSABLE SECTION ///////

/// List Entry small ///
@Composable
fun ListEntry(){
    //Starting Row
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = ListEntryBoxModifier
            .fillMaxWidth()
            .padding(
                start = Dp( 10f),
                end = Dp( 10f ),
                top =  Dp(15f),
                bottom =  Dp(15f)
            )
    ){
        //Bild des Arztes
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                painter = painterResource(Res.drawable.mockimage),
                "MockImage",
                contentScale = ContentScale.Crop,
                modifier = ProfilePictureModifier)

            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(
                        start = Dp(5f)
                    )
            ) {
                //Name des Arztes
                Text(text = "Rita Strauß", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFF202020))
                //Spezialisierung des Arztes
                Row {
                    //Hier kommt eigentlich das tierspezifische Icon hin
                    Icon(Icons.Rounded.Star, contentDescription = "Star Placeholder Icon", tint = Color(0xFF959494), modifier = Modifier.padding(start = 2.dp))
                    Text(text = "Schäferhunde", fontWeight = FontWeight.Medium, color = Color(0xFF959494))
                }
            }
        }

        //Rating
        Row{
            //Paw Group
            Row{
                Icon(Icons.Rounded.Star, contentDescription = "Star Placeholder Icon", tint = Color(0xFF00D47B), modifier = StarModifier)
                Icon(Icons.Rounded.Star, contentDescription = "Star Placeholder Icon", tint = Color(0xFF00D47B), modifier = StarModifier)
                Icon(Icons.Rounded.Star, contentDescription = "Star Placeholder Icon", tint = Color(0xFF00D47B), modifier = StarModifier)
                Icon(Icons.Rounded.Star, contentDescription = "Star Placeholder Icon", tint = Color(0xFF00D47B), modifier = StarModifier)
                Icon(Icons.Rounded.Star, contentDescription = "Star Placeholder Icon", tint = Color(0xFF00D47B), modifier = StarModifier)
            }
            Text(text = "4,7", fontWeight = FontWeight.SemiBold, color = Color(0xFF202020))
        }
    }
}




/// List Entry big ///
@Composable
fun ListEntryBig(){
    //Starting Column
    Column(
        modifier = ListEntryBoxModifier
            .fillMaxWidth()
            .padding(
                start = Dp( 10f),
                end = Dp( 10f ),
                top =  Dp(15f),
                bottom =  Dp(15f)
            )
    ) {
        //Starting Row
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ){
            //Bild des Arztes
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painter = painterResource(Res.drawable.mockimage),
                    "MockImage",
                    contentScale = ContentScale.Crop,
                    modifier = ProfilePictureModifier)

                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(
                            start = Dp(5f)
                        )
                ) {
                    //Name des Arztes
                    Text(text = "Rita Strauß", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFF202020))
                    //Spezialisierung des Arztes
                    Row {
                        //Hier kommt eigentlich das tierspezifische Icon hin
                        Icon(Icons.Rounded.Star, contentDescription = "Star Placeholder Icon", tint = Color(0xFF959494), modifier = Modifier.padding(start = 2.dp))
                        Text(text = "Schäferhunde", fontWeight = FontWeight.Medium, color = Color(0xFF959494))
                    }
                }
            }
            //Rating
            Row{
                //Paw Group
                Row{
                    Icon(Icons.Rounded.Star, contentDescription = "Star Placeholder Icon", tint = Color(0xFF00D47B), modifier = StarModifier)
                    Icon(Icons.Rounded.Star, contentDescription = "Star Placeholder Icon", tint = Color(0xFF00D47B), modifier = StarModifier)
                    Icon(Icons.Rounded.Star, contentDescription = "Star Placeholder Icon", tint = Color(0xFF00D47B), modifier = StarModifier)
                    Icon(Icons.Rounded.Star, contentDescription = "Star Placeholder Icon", tint = Color(0xFF00D47B), modifier = StarModifier)
                    Icon(Icons.Rounded.Star, contentDescription = "Star Placeholder Icon", tint = Color(0xFF00D47B), modifier = StarModifier)
                }
                Text(text = "4,7", fontWeight = FontWeight.SemiBold, color = Color(0xFF202020))
            }
        }
        //Metainformationen
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(top = 20.dp)
        ) {
            Row {
                Icon(Icons.Rounded.Star, contentDescription = "Star Placeholder Icon", tint = Color(0xFF959494), modifier = Modifier.padding(start = 2.dp))
                Text(text = "Kleintierpraxis Mustermann", fontWeight = FontWeight.SemiBold, color = Color(0xFF959494))
            }
            Row {
                Icon(Icons.Rounded.Place, contentDescription = "Map-Pin Icon", tint = Color(0xFF959494), modifier = Modifier.padding(start = 2.dp))
                Text(text = "Fantasiestraße 4, Fantasiestadt", fontWeight = FontWeight.Medium, color = Color(0xFF959494))
            }
            Row {
                Icon(Icons.Rounded.Star, contentDescription = "Distance Icon", tint = Color(0xFF959494), modifier = Modifier.padding(start = 2.dp))
                Text(text = "10,4km", fontWeight = FontWeight.Medium, color = Color(0xFF959494))
            }
        }

        //Bewertungen
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
        )
        {
            Text(text = "Bewertungen", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFF202020))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()

            ) {
                Text(text = "Diagnose")
                Row{
                    //Paw Group
                    Row{
                        Icon(Icons.Rounded.Star, contentDescription = "Star Placeholder Icon", tint = Color(0xFF00D47B), modifier = StarModifier)
                        Icon(Icons.Rounded.Star, contentDescription = "Star Placeholder Icon", tint = Color(0xFF00D47B), modifier = StarModifier)
                        Icon(Icons.Rounded.Star, contentDescription = "Star Placeholder Icon", tint = Color(0xFF00D47B), modifier = StarModifier)
                        Icon(Icons.Rounded.Star, contentDescription = "Star Placeholder Icon", tint = Color(0xFF00D47B), modifier = StarModifier)
                        Icon(Icons.Rounded.Star, contentDescription = "Star Placeholder Icon", tint = Color(0xFF00D47B), modifier = StarModifier)
                    }
                    Text(text = "12", fontWeight = FontWeight.SemiBold, color = Color(0xFF202020))
                }

            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()

            ) {
                Text(text = "Behandlung")
                Row{
                    //Paw Group
                    Row{
                        Icon(Icons.Rounded.Star, contentDescription = "Star Placeholder Icon", tint = Color(0xFF00D47B), modifier = StarModifier)
                        Icon(Icons.Rounded.Star, contentDescription = "Star Placeholder Icon", tint = Color(0xFF00D47B), modifier = StarModifier)
                        Icon(Icons.Rounded.Star, contentDescription = "Star Placeholder Icon", tint = Color(0xFF00D47B), modifier = StarModifier)
                        Icon(Icons.Rounded.Star, contentDescription = "Star Placeholder Icon", tint = Color(0xFF00D47B), modifier = StarModifier)
                        Icon(Icons.Rounded.Star, contentDescription = "Star Placeholder Icon", tint = Color(0xFF00D47B), modifier = StarModifier)
                    }
                    Text(text = "23", fontWeight = FontWeight.SemiBold, color = Color(0xFF202020))
                }

            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()

            ) {
                Text(text = "Empathie")
                Row{
                    //Paw Group
                    Row{
                        Icon(Icons.Rounded.Star, contentDescription = "Star Placeholder Icon", tint = Color(0xFF00D47B), modifier = StarModifier)
                        Icon(Icons.Rounded.Star, contentDescription = "Star Placeholder Icon", tint = Color(0xFF00D47B), modifier = StarModifier)
                        Icon(Icons.Rounded.Star, contentDescription = "Star Placeholder Icon", tint = Color(0xFF00D47B), modifier = StarModifier)
                        Icon(Icons.Rounded.Star, contentDescription = "Star Placeholder Icon", tint = Color(0xFF00D47B), modifier = StarModifier)
                        Icon(Icons.Rounded.Star, contentDescription = "Star Placeholder Icon", tint = Color(0xFF00D47B), modifier = StarModifier)
                    }
                    Text(text = "47", fontWeight = FontWeight.SemiBold, color = Color(0xFF202020))
                }
            }
        }

        //Erfahrungsberichte
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
        ) {
            Text(text = "Erfahrungsberichte" ,fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFF202020))

            HorizontalDivider(thickness = 1.dp, modifier = Modifier.padding(top = 5.dp, bottom = 5.dp))
            //Kommentar
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {



               Row(
                   verticalAlignment = Alignment.CenterVertically,
                   horizontalArrangement = Arrangement.SpaceBetween,
                   modifier = Modifier
                       .fillMaxWidth()
               ) {
                   //Profil
                   Row(
                       verticalAlignment = Alignment.CenterVertically
                   ) {
                       Image(
                           painter = painterResource(Res.drawable.hundewelpe),
                           "MockImage",
                           contentScale = ContentScale.Crop,
                           modifier = ProfileCommentIctureModifier
                       )
                       Text(text = "Fridolin", fontSize = 15.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF202020), modifier = Modifier.padding(start = 3.dp))
                   }

                   //Rating
                   Row {
                       Row{
                           //Paw Group
                           Row{
                               Icon(Icons.Rounded.Star, contentDescription = "Star Placeholder Icon", tint = Color(0xFF00D47B), modifier = StarModifier)
                               Icon(Icons.Rounded.Star, contentDescription = "Star Placeholder Icon", tint = Color(0xFF00D47B), modifier = StarModifier)
                               Icon(Icons.Rounded.Star, contentDescription = "Star Placeholder Icon", tint = Color(0xFF00D47B), modifier = StarModifier)
                               Icon(Icons.Rounded.Star, contentDescription = "Star Placeholder Icon", tint = Color(0xFF00D47B), modifier = StarModifier)
                               Icon(Icons.Rounded.Star, contentDescription = "Star Placeholder Icon", tint = Color(0xFF00D47B), modifier = StarModifier)
                           }
                           Text(text = "4,7", fontWeight = FontWeight.SemiBold, color = Color(0xFF202020))
                       }
                   }
               }
                Text(text ="Ich war mit dem Besuch super zufrieden. Die Sprize tat auch gar nicht weh!")
            }

            HorizontalDivider(thickness = 1.dp, modifier = Modifier.padding(top = 5.dp, bottom = 5.dp))
            //Kommentar
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                ){
                    //Profil
                    Row (
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(Res.drawable.gecko),
                            "MockImage",
                            contentScale = ContentScale.Crop,
                            modifier = ProfileCommentIctureModifier
                        )
                        Text(text = "Thorsten", fontSize = 15.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF202020), modifier = Modifier.padding(start = 3.dp))
                    }

                    //Rating
                    Row {
                        Row{
                            //Paw Group
                            Row{
                                Icon(Icons.Rounded.Star, contentDescription = "Star Placeholder Icon", tint = Color(0xFF00D47B), modifier = StarModifier)
                                Icon(Icons.Rounded.Star, contentDescription = "Star Placeholder Icon", tint = Color(0xFF00D47B), modifier = StarModifier)
                                Icon(Icons.Rounded.Star, contentDescription = "Star Placeholder Icon", tint = Color(0xFF00D47B), modifier = StarModifier)
                                Icon(Icons.Rounded.Star, contentDescription = "Star Placeholder Icon", tint = Color(0xFF00D47B), modifier = StarModifier)
                                Icon(Icons.Rounded.Star, contentDescription = "Star Placeholder Icon", tint = Color(0xFF00D47B), modifier = StarModifier)
                            }
                            Text(text = "2,7", fontWeight = FontWeight.SemiBold, color = Color(0xFF202020))
                        }
                    }
                }
                Text(text ="Ich fand die Dame am Tresen, die extrem laut hervorgehoben hat, wie süß ich denn wäre ein bisschen stressig, aber der Arzt war total lieb.")
            }

            HorizontalDivider(thickness = 1.dp, modifier = Modifier.padding(top = 5.dp, bottom = 5.dp))
            //Kommentar
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    //Profil
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(Res.drawable.pfau),
                            "Susi",
                            contentScale = ContentScale.Crop,
                            modifier = ProfileCommentIctureModifier
                        )
                        Text(text = "Susi",  fontSize = 15.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF202020), modifier = Modifier.padding(start = 3.dp))
                    }

                    //Rating
                    Row {
                        Row{
                            //Paw Group
                            Row{
                                Icon(Icons.Rounded.Star, contentDescription = "Star Placeholder Icon", tint = Color(0xFF00D47B), modifier = StarModifier)
                                Icon(Icons.Rounded.Star, contentDescription = "Star Placeholder Icon", tint = Color(0xFF00D47B), modifier = StarModifier)
                                Icon(Icons.Rounded.Star, contentDescription = "Star Placeholder Icon", tint = Color(0xFF00D47B), modifier = StarModifier)
                                Icon(Icons.Rounded.Star, contentDescription = "Star Placeholder Icon", tint = Color(0xFF00D47B), modifier = StarModifier)
                                Icon(Icons.Rounded.Star, contentDescription = "Star Placeholder Icon", tint = Color(0xFF00D47B), modifier = StarModifier)
                            }
                            Text(text = "2,7", fontWeight = FontWeight.SemiBold, color = Color(0xFF202020))
                        }
                    }
                }
                Text(text ="Alle fanden mich total süüüüüüüüüüüüüüüüüüß!!!!")
            }

        }

        //Button Section
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp)
            ) {
            Text(text="Weitere Erfahrungsberichte", fontWeight = FontWeight.SemiBold, modifier = ButtonModifier
                .padding(start = 10.dp, end = 10.dp, top = 5.dp, bottom = 5.dp)
            )
        }
    }
}
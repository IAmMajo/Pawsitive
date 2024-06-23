package ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
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
import androidx.compose.ui.unit.sp


////// VALUE SECTION ///////

val ProfilePictureModifier = Modifier
    .size(70.dp)
    .clip(CircleShape)

val ListEntryBoxModifier = Modifier
    .clip(RoundedCornerShape(Dp(20f)))
    .shadow(elevation = Dp(20f), spotColor = Color(0xff3a3a3a))
    .background(Color.White)

val StarModifier = Modifier
    .size(24.dp)


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
                top =  Dp(20f),
                bottom =  Dp(20f)
            )
    ){
        //Bild des Arztes
        Row{
            Image(
                painter = painterResource(Res.drawable.mockimage),
                "MockImage",
                contentScale = ContentScale.Crop,
                modifier = ProfilePictureModifier)

            Column(
                modifier = Modifier
                    .padding(
                        start = Dp(5f)
                    )
            ) {
                //Name des Arztes
                Text(text = "Rita Strauß", fontSize = 25.sp, fontWeight = FontWeight.Bold)
                //Spezialisierung des Arztes
                Row {
                    //Hier kommt eigentlich das tierspezifische Icon hin
                    Icon(Icons.Rounded.Star, contentDescription = "Star Placeholder Icon")
                    Text(text = "Schäferhunde", fontWeight = FontWeight.Medium)
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
            Text(text = "4,7", fontWeight = FontWeight.SemiBold)
        }
    }
}

/// List Entry big ///

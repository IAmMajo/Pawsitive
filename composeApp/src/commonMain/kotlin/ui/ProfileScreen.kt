package ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import pawsitive.composeapp.generated.resources.Res
import pawsitive.composeapp.generated.resources.gecko

@Composable
@Preview
fun ProfileScreen() {
  Column {
    Box(
        modifier =
            Modifier.height(250.dp).clip(RoundedCornerShape(8.dp)).padding(5.dp).fillMaxWidth()) {
          Image(
              painter = painterResource(Res.drawable.gecko),
              contentDescription = null,
              contentScale = ContentScale.Crop,
              modifier = Modifier.fillMaxSize().clip(RoundedCornerShape(8.dp)))
          Column(
              verticalArrangement = Arrangement.Bottom,
              horizontalAlignment = Alignment.Start,
              modifier = Modifier.fillMaxSize()) {
                Text(
                    text = "Thomas (19 Jahre alt)",
                    color = Color.LightGray,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    modifier = Modifier.padding(horizontal = 16.dp))
                Text(
                    text = "Stirnlappenbasilisk",
                    color = Color.LightGray,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 6.dp))
              }
        }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier =
            Modifier.fillMaxWidth()
                .height(200.dp)
                .padding(5.dp)
                .background(Color(0xFF00D47B), shape = RoundedCornerShape(15.dp))
                .clip(RoundedCornerShape(8.dp))
                .padding(10.dp)) {
          Column(horizontalAlignment = Alignment.Start) {
            Text(text = "Spritze für Thomas", fontSize = 18.sp, color = Color(0xFF202020))
            Text(
                text = "28. April 2024",
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF202020))
          }
        }
  }
}

// Hier könnte man dann auch die Ärzte eintragen, die man bereits besucht hat
// DB Anbindung

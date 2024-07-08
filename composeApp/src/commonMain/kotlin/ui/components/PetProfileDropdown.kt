import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import pawsitive.composeapp.generated.resources.Res
import pawsitive.composeapp.generated.resources.gecko
import pawsitive.composeapp.generated.resources.hundewelpe
import pawsitive.composeapp.generated.resources.pfau
import ui.theme.ProfilePictureModifier
import ui.theme.starNotSelectedColor
import ui.theme.subHeadingColor

@Composable
fun PetProfileDropdown() {
  var expanded by remember { mutableStateOf(false) }
  var selectedPet by remember { mutableStateOf(Pair("Fridolin", Res.drawable.gecko)) }

  val pets =
      listOf(
          Pair("Fridolin", Res.drawable.gecko),
          Pair("Richard", Res.drawable.pfau),
          Pair("Bella", Res.drawable.hundewelpe),
      )

  Row(modifier = Modifier.padding(start = 22.dp, top = 22.dp, end = 12.dp).fillMaxWidth()) {
    Image(
        painter = painterResource(selectedPet.second),
        contentDescription = "MockImagePetProfile",
        contentScale = ContentScale.Crop,
        modifier = ProfilePictureModifier,
    )
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth().height(60.dp).clickable { expanded = true },
    ) {
      Text(
          text = selectedPet.first,
          color = subHeadingColor,
          fontSize = 18.sp,
          fontWeight = FontWeight.Bold,
          modifier = Modifier.padding(start = 5.dp),
      )
      Button(
          onClick = { expanded = true },
          colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
      ) {
        Icon(
            Icons.Rounded.ArrowDropDown,
            contentDescription = "Arrow Drop Down Icon",
            tint = starNotSelectedColor,
            modifier = Modifier.clip(RoundedCornerShape(50f)).background(Color.LightGray),
        )
      }
    }
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false },
    ) {
      pets.forEach { pet ->
        DropdownMenuItem(
            onClick = {
              selectedPet = pet
              expanded = false
            },
            text = { Text(text = pet.first) },
        )
      }
    }
  }
}

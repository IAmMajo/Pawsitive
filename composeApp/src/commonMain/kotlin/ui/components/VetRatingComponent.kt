package ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ui.theme.greenTextColor
import ui.theme.lightText
import ui.theme.textFieldColor

@Composable
fun RatingArztComponent() {
  Column(modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)) {

    // Rating Diagnose
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
      Text(text = "Diagnose", fontWeight = FontWeight.Medium, color = lightText)

      /////////////////////////////////////////////////////////////////////////////////////
      // StarRating

      Row(
          // modifier = Modifier.fillMaxSize(),
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.SpaceBetween,
      ) {
        var rating_1 by remember { mutableDoubleStateOf(0.0) }

        StarRow(
            modifier = Modifier,
            rating = rating_1,
        ) {
          rating_1 = it
        }
      }
    }
    /// Rating Behandlung
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
      Text(
          text = "Behandlung",
          fontWeight = FontWeight.Medium,
          color = lightText,
      )
      Row(
          // modifier = Modifier.fillMaxSize(),
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.SpaceBetween,
      ) {
        var rating_1 by remember { mutableDoubleStateOf(0.0) }

        StarRow(
            modifier = Modifier,
            rating = rating_1,
        ) {
          rating_1 = it
        }
      }
    }

    /// Rating Aufklärung
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
      Text(text = "Aufklärung", fontWeight = FontWeight.Medium, color = lightText)
      Row(
          // modifier = Modifier.fillMaxSize(),
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.SpaceBetween,
      ) {
        var rating_1 by remember { mutableDoubleStateOf(0.0) }

        StarRow(
            modifier = Modifier,
            rating = rating_1,
        ) {
          rating_1 = it
        }
      }
    }

    /// Rating Vertrauensverhältnis
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
      Text(text = "Vertrauensverhältnis", fontWeight = FontWeight.Medium, color = lightText)
      Row(
          // modifier = Modifier.fillMaxSize(),
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.SpaceBetween,
      ) {
        var rating_1 by remember { mutableDoubleStateOf(0.0) }

        StarRow(
            modifier = Modifier,
            rating = rating_1,
        ) {
          rating_1 = it
        }
      }
    }

    /// Rating investierte Zeit
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
      Text(text = "Investierte Zeit", fontWeight = FontWeight.Medium, color = lightText)
      Row(
          // modifier = Modifier.fillMaxSize(),
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.SpaceBetween,
      ) {
        var rating_1 by remember { mutableDoubleStateOf(0.0) }

        StarRow(
            modifier = Modifier,
            rating = rating_1,
        ) {
          rating_1 = it
        }
      }
    }

    /// Rating Freundlichkeit
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
      Text(text = "Freundlichkeit", fontWeight = FontWeight.Medium, color = lightText)
      Row(
          // modifier = Modifier.fillMaxSize(),
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.SpaceBetween,
      ) {
        var rating_1 by remember { mutableDoubleStateOf(0.0) }

        StarRow(
            modifier = Modifier,
            rating = rating_1,
        ) {
          rating_1 = it
        }
      }
    }

    //// Textfeld - Rating Arzt ////
    val rating = remember { mutableStateOf("") }

    OutlinedTextField(
        value = rating.value,
        onValueChange = { rating.value = it },
        modifier = TextFieldModifier,
        label = { Text("Feedback...") },
        // colors = OutlinedTextFieldDefaults.colors(textFieldColor),
        colors =
            OutlinedTextFieldDefaults.colors(
                unfocusedLabelColor = textFieldColor,
                focusedLabelColor = greenTextColor,
                unfocusedBorderColor = textFieldColor,
                focusedBorderColor = greenTextColor,
            ),
    )
  }
}

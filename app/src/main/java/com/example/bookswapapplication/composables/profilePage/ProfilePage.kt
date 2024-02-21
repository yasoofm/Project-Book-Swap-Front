package com.example.bookswapapplication.composables.profilePage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.bookswapapplication.R
import com.example.bookswapapplication.ui.theme.BookSwapApplicationTheme


@Composable
fun ProfilePage() {
    val genderOptions = listOf("Male", "Female")
    var name by remember { mutableStateOf("faten") }
    var email by remember { mutableStateOf("faten@gmail.com") }
    var phoneNumber by remember { mutableStateOf("+965 45863579") }
    var selectedGender by remember { mutableStateOf("Female") }

    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Box(
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .align(Alignment.CenterHorizontally)
        ) {
            Image(
                painter = painterResource(id = R.drawable.pro1),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))


        Text(
            text = name,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(8.dp))


        ProfileField(Icons.Default.Email, email)

        Spacer(modifier = Modifier.height(8.dp))


        ProfileField(Icons.Default.Phone, phoneNumber)
        Spacer(modifier = Modifier.height(8.dp))

        ProfileField(Icons.Default.DateRange, "JUNE 6, 1998")

        Spacer(modifier = Modifier.height(8.dp))


//        ProfileField(Icons.Default.Face, "Female")


        Spacer(modifier = Modifier.height(8.dp))
        GenderDropdown(genderOptions, selectedGender) { gender ->
            selectedGender = gender
        }

        Spacer(modifier = Modifier.height(8.dp))
        SettingsButton()
    }
}
@Composable
fun GenderDropdown(genderOptions: List<String>, selectedGender: String, onGenderSelected: (String) -> Unit) {
    var showDialog by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { showDialog = true }
            .background(Color.White)
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Face,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = selectedGender, style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            imageVector = Icons.Default.ArrowDropDown,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary
        )
    }
    if (showDialog) {
        GenderDialog(genderOptions, selectedGender) { gender ->
            onGenderSelected(gender)
            showDialog = false
        }
    }
}
@Composable
fun GenderDialog(genderOptions: List<String>, selectedGender: String, onGenderSelected: (String) -> Unit) {
    Dialog(onDismissRequest = { }) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            genderOptions.forEach { gender ->
                Text(
                    text = gender,
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxWidth()
                        .clickable {
                            onGenderSelected(gender)
                        }
                        .padding(8.dp)
                )
            }
        }
    }
}



@Composable
fun ProfileField(icon: ImageVector, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = value, style = MaterialTheme.typography.bodyMedium)
    }
}

@Composable
fun SettingsButton() {
    ProfileField(
        icon = Icons.Default.Settings,
        value = "Settings",

        )
}

@Preview(showBackground = true)
@Composable
fun ProfilePagePreview() {
    BookSwapApplicationTheme {
        ProfilePage()
    }
}
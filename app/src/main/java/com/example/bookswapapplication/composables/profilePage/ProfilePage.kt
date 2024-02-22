package com.example.bookswapapplication.composables.profilePage

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
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
import com.example.bookswapapplication.composables.MainPage.BookSection
import com.example.bookswapapplication.composables.MainPage.BottomNavigationBar
import com.example.bookswapapplication.composables.MainPage.FavSection
import com.example.bookswapapplication.composables.MainPage.MostSwipedSection
import com.example.bookswapapplication.composables.MainPage.TopSection
import com.example.bookswapapplication.composables.bookrec
import com.example.bookswapapplication.data.User
import com.example.bookswapapplication.ui.theme.BookSwapApplicationTheme
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date



@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ProfilePage(user: User, toBookList: () -> Unit, toNotifications: () -> Unit, toHomeScreen: () -> Unit, toAccount: () -> Unit) {
    var selectedGender by remember { mutableStateOf("Male") }
    val genderOptions = listOf("Male", "Female")

    Scaffold(
        bottomBar = {
            BottomNavigationBar(toBookList = toBookList, toNotifications = toNotifications, toAccount = toAccount, toHomeScreen = toHomeScreen)
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize()
                .padding(padding)
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
                text = user.name?: "No Name",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(8.dp))


            ProfileField(Icons.Default.Email, user.email)

            Spacer(modifier = Modifier.height(8.dp))


            ProfileField(Icons.Default.Phone, user.phoneNumber?: "No Number")
            Spacer(modifier = Modifier.height(8.dp))

            ProfileField(Icons.Default.DateRange, LocalDate.now().format(DateTimeFormatter.ofPattern("d-MM-y")))

            Spacer(modifier = Modifier.height(8.dp))

            Spacer(modifier = Modifier.height(8.dp))
            GenderDropdown(genderOptions, selectedGender) { gender ->
                selectedGender = gender
            }
        }
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


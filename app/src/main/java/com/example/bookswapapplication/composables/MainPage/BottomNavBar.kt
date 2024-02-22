package com.example.bookswapapplication.composables.MainPage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.List
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bookswapapplication.composables.MainPage.data.BottomNavigation
@Composable
fun BottomNavigationBar(toBookList: () -> Unit, toNotifications: () -> Unit, toAccount: () -> Unit, toHomeScreen: () -> Unit) {

    val items = listOf(
        BottomNavigation(
            title = "Home",
            icon = Icons.Rounded.Home,
            destination = {toHomeScreen}
        ),

        BottomNavigation(
            title = "Book List",
            icon = Icons.Rounded.List,
            destination = toBookList
        ),

        BottomNavigation(
            title = "Notifications",
            icon = Icons.Rounded.Notifications,
            destination = toNotifications
        ),

        BottomNavigation(
            title = "Account",
            icon = Icons.Rounded.AccountCircle,
            destination = toAccount
        )
    )

    NavigationBar {
        Row(
            modifier = Modifier.background(MaterialTheme.colorScheme.inverseOnSurface)
        ) {
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    selected = false,
                    onClick = {item.destination()},
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title,
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    },
                    label = {
                        Text(
                            text = item.title,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                )
            }

        }
    }
}

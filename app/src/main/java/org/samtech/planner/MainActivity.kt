package org.samtech.planner

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.samtech.planner.ui.BottomNavItem
import org.samtech.planner.ui.theme.PlannerTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlannerTheme {
                Scaffold(
                    bottomBar = { BottomNavigation() },
                ) {}
            }
        }
    }
}

@Composable
fun BottomNavigation() {
    val items = listOf(
        BottomNavItem.Calendar,
        BottomNavItem.Home
    )

    NavigationBar(
        tonalElevation = 0.dp, //this is for transparency color
        containerColor = colorResource(id = R.color.white)//this is background color of the bottom navbar
    ) {
        items.forEach { item ->
            AddItem(screen = item)
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomNavItem
) {
    NavigationBarItem(
        label = {
            Text(
                text = screen.title,
                style = TextStyle(
                    fontWeight = FontWeight.Bold
                )
            )
        },
        icon = {
            Icon(
                painterResource(id = screen.icon),
                contentDescription = screen.title
            )
        },
        selected = true,
        alwaysShowLabel = true,
        onClick = {},
        colors =  NavigationBarItemDefaults.colors(
            //selectedIconColor = colorResource(id = R.color.orange), //this is selected icon color
            selectedTextColor = colorResource(id = R.color.darkblue),
            indicatorColor = colorResource(id = R.color.ligthblue),//this is the color of the inner chips
            //unselectedIconColor = colorResource(id = R.color.black),
            unselectedTextColor = colorResource(id = R.color.orange)
        )
    )
}

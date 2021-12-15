package com.moon.mysecretary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.moon.mysecretary.ui.SplashScreen
import com.moon.mysecretary.ui.theme.MysecretaryTheme
import com.moon.mysecretary.ui.theme.graySurface

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MysecretaryTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = Color.White, modifier = Modifier.fillMaxSize()) {
                    Navigation()
                }
            }
        }
    }
}

@Composable
fun MainScreen(navController: NavController) {
    Scaffold(topBar = {}, floatingActionButton = {
        FloatingActionButton(onClick = {
            navController.navigate("edit_screen")
        }, contentColor = graySurface) {
            Icon(Icons.Filled.Add, "")
        }
    }, content = {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = "Main Screen", color = Color.Black, fontSize = 24.sp)
        }
    })
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "splash_screen") {
        composable("splash_screen") {
            SplashScreen(navController)
        }
        composable("main_screen") {
            MainScreen(navController)
        }
        composable("edit_screen") {
            EditScreen(navController)
        }
    }
}


@Composable
fun EditScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Edit Screen", color = Color.Black, fontSize = 24.sp)
    }
}
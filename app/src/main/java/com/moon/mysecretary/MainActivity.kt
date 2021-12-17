package com.moon.mysecretary

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.moon.mysecretary.ui.SplashScreen
import com.moon.mysecretary.ui.theme.MysecretaryTheme
import com.moon.mysecretary.ui.theme.graySurface
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.datetime.time.timepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState

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

    var text by remember { mutableStateOf("") }
    val dialogDateState = rememberMaterialDialogState()
    val dialogTimeState = rememberMaterialDialogState()
    var dateTime by remember { mutableStateOf("") }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column {
            OutlinedTextField(value = text, onValueChange = {
                text = it
            }, label = { Text("알람 이름") })
            MaterialDialog(dialogState = dialogTimeState,
                buttons = {
                    positiveButton("Complete", onClick = {
                        dialogTimeState.hide()
                    })
                    negativeButton("Cancel", onClick = {
                        dialogTimeState.hide()
                    })
                }) {
                timepicker { time ->
                    dateTime = "$dateTime $time"
                    Log.i("MQ!", "time:$time")
                }
            }
            MaterialDialog(
                dialogState = dialogDateState,
                buttons = {
                    positiveButton(text = "Next", onClick = {
                        dialogDateState.hide()
                        dialogTimeState.show()
                    })
                    negativeButton(text = "Cancel", onClick = {
                        dialogDateState.hide()
                    })
                }
            ) {
                datepicker { date ->
                    dateTime = "$date"
                    Log.i("MQ!", "date:$date")
                }
            }
            Text(text = "시작날짜", modifier = Modifier.clickable {
                dialogDateState.show()
            })
            Text(text = dateTime)
        }
    }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Text(
                text = "확인",
                color = Color.Black,
                fontSize = 24.sp,
                modifier = Modifier
                    .size(width = 100.dp, height = 40.dp)
                    .clickable {
                        navController.navigate("main_screen")
                    }, style = TextStyle(textAlign = TextAlign.Center)
            )
            Text(
                text = "취소",
                color = Color.Black,
                fontSize = 24.sp,
                modifier = Modifier
                    .size(width = 100.dp, height = 40.dp)
                    .clickable {
                        navController.navigate("main_screen")
                    }, style = TextStyle(textAlign = TextAlign.Center)
            )
        }
    }

}
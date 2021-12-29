package com.moon.mysecretary.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun EditScreen(navController: NavController) {

    var editMode by remember { mutableStateOf(0) }
    Column {
        TopAppBar(
            elevation = 4.dp,
            title = {
                val textState = remember { mutableStateOf(TextFieldValue()) }
                TextField(
                    value = textState.value,
                    onValueChange = { textState.value = it }
                )
            },
            backgroundColor = MaterialTheme.colors.primarySurface,
            navigationIcon = {
                IconButton(onClick = {/* Do Something*/ }) {
                    Icon(Icons.Filled.ArrowBack, null)
                }
            }, actions = {
                IconButton(onClick = {/* Do Something*/ }) {
                    Icon(Icons.Filled.Share, null)
                }
                IconButton(onClick = {/* Do Something*/ }) {
                    Icon(Icons.Filled.Settings, null)
                }
            })
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            elevation = 10.dp
        ) {
            Column(
                modifier = Modifier.padding(15.dp)
            ) {
                Text(
                    buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.W900,
                                color = Color(0xFF4552B8)
                            )
                        ) {
                            append("                ?                ")
                        }
                        append("마다")
                    },
                    modifier = Modifier.clickable {
                        editMode = 1
                    }
                )
                Text(
                    buildAnnotatedString {
                        withStyle(style = SpanStyle(fontWeight = FontWeight.W900)) {
                            append("진동 및 알람 설정 ")
                        }
                        append("울린다!!")
                    },
                    modifier = Modifier.clickable {
                        editMode = 2
                    }
                )
            }
        }
        Divider(color = Color.Black, thickness = 1.dp)
        when (editMode) {
            1 -> PeriodComposable()
            2 -> AlarmComposable()
        }
    }
}

@Composable
fun PeriodComposable() {
    PeriodYear()
    PeriodMonth()
    PeriodWeek()
}

@Composable
fun PeriodYear () {
    val textState = remember { mutableStateOf(TextFieldValue()) }
    Column {
        Text("매년", modifier = Modifier.padding(start = 16.dp, bottom = 6.dp))
        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
            OutlinedTextField(
                value = textState.value,
                onValueChange = {
                    textState.value = it
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.size(width = 80.dp, height = 30.dp)
            )
            Text(text = "년", modifier = Modifier.padding(horizontal = 3.dp))
            OutlinedTextField(
                value = textState.value,
                onValueChange = {
                    textState.value = it
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.size(width = 80.dp, height = 30.dp)
            )
            Text(text = "월", modifier = Modifier.padding(horizontal = 3.dp))
            OutlinedTextField(
                value = textState.value,
                onValueChange = {
                    textState.value = it
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.size(width = 80.dp, height = 30.dp)
            )
            Text(text = "일", modifier = Modifier.padding(horizontal = 3.dp))
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
        ) {
            OutlinedTextField(
                value = textState.value,
                onValueChange = {
                    textState.value = it
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.size(width = 50.dp, height = 30.dp)
            )
            Text(text = " : ")
            OutlinedTextField(
                value = textState.value,
                onValueChange = {
                    textState.value = it
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.size(width = 50.dp, height = 30.dp)
            )
        }
        Divider(color = Color.Black, thickness = 0.8.dp, modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp))
    }
}


@Composable
fun PeriodMonth () {
    val textState = remember { mutableStateOf(TextFieldValue()) }
    Column {
        Text("매월", modifier = Modifier.padding(start = 16.dp, bottom = 6.dp))
        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
            OutlinedTextField(
                value = textState.value,
                onValueChange = {
                    textState.value = it
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.size(width = 80.dp, height = 30.dp)
            )
            Text(text = "일", modifier = Modifier.padding(horizontal = 3.dp))
        }
        Divider(color = Color.Black, thickness = 0.8.dp, modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp))
    }
}


@Composable
fun PeriodWeek() {
    val textState = remember { mutableStateOf(TextFieldValue()) }
    Column {
        Text("매주", modifier = Modifier.padding(start = 16.dp, bottom = 6.dp))
        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
            Text(text = "일", modifier = Modifier.padding(horizontal = 3.dp), color = Color.Red)
            Text(text = "월", modifier = Modifier.padding(horizontal = 3.dp))
            Text(text = "화", modifier = Modifier.padding(horizontal = 3.dp))
            Text(text = "수", modifier = Modifier.padding(horizontal = 3.dp))
            Text(text = "목", modifier = Modifier.padding(horizontal = 3.dp))
            Text(text = "금", modifier = Modifier.padding(horizontal = 3.dp))
            Text(text = "토", modifier = Modifier.padding(horizontal = 3.dp), color = Color.Blue)
        }
        Divider(color = Color.Black, thickness = 0.8.dp, modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp))
    }
}
@Composable
fun AlarmComposable() {
    OutlinedButton(onClick = { /* Do something! */ }) {
        Text("AlarmComposable")
    }
}


//
//    var text by remember { mutableStateOf("") }
//    val dialogDateState = rememberMaterialDialogState()
//    val dialogTimeState = rememberMaterialDialogState()
//    var dateTime by remember { mutableStateOf("") }
//    dateTime = SimpleDateFormat("yyyy-MM-dd, hh:mm:ss a").format(Date()).toString()
//    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//        Column {
//            OutlinedTextField(value = text, onValueChange = {
//                text = it
//            }, label = { Text("알람 이름") })
//            MaterialDialog(dialogState = dialogTimeState,
//                buttons = {
//                    positiveButton("Complete", onClick = {
//                        dialogTimeState.hide()
//                    })
//                    negativeButton("Cancel", onClick = {
//                        dialogTimeState.hide()
//                    })
//                }) {
//                timepicker { time ->
//                    dateTime = "$dateTime $time"
//                    Log.i("MQ!", "time:$time")
//                }
//            }
//            MaterialDialog(
//                dialogState = dialogDateState,
//                buttons = {
//                    positiveButton(text = "Next", onClick = {
//                        dialogDateState.hide()
//                        dialogTimeState.show()
//                    })
//                    negativeButton(text = "Cancel", onClick = {
//                        dialogDateState.hide()
//                    })
//                }
//            ) {
//                datepicker { date ->
//                    dateTime = "$date"
//                    Log.i("MQ!", "date:$date")
//                }
//            }
//            Row {
//                Text(text = "시작날짜", modifier = Modifier.clickable {
//                    dialogDateState.show()
//                })
//                Text(text = dateTime)
//            }
//            Row {
//                Text(text="마다", modifier=Modifier.clickable {
//
//                })
//            }
//        }
//    }
//    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
//        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
//            Text(
//                text = "확인",
//                color = Color.Black,
//                fontSize = 24.sp,
//                modifier = Modifier
//                    .size(width = 100.dp, height = 40.dp)
//                    .clickable {
//                        navController.navigate("main_screen")
//                    }, style = TextStyle(textAlign = TextAlign.Center)
//            )
//            Text(
//                text = "취소",
//                color = Color.Black,
//                fontSize = 24.sp,
//                modifier = Modifier
//                    .size(width = 100.dp, height = 40.dp)
//                    .clickable {
//                        navController.navigate("main_screen")
//                    }, style = TextStyle(textAlign = TextAlign.Center)
//            )
//        }
//    }
package com.silveira.lista_tarefas.screens

import android.annotation.SuppressLint
import android.widget.CheckBox
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.silveira.lista_tarefas.R


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListarTarefas(navController: NavController){
    var todos = remember { mutableStateListOf<String>() }
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFFF9F1F9)),
                title = {
                    Text (
                        text = "Task List",
                        fontSize = 6.dp,
                        fontWeight = FontWeight.Bold,
                        color = 0xFF1D1A20
                        )
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("TelaSalvar")
                },
                containerColor = Color(0xFFF9F1F9)
            ) {
                Icon(Icons.Filled.Add, stringResource(id = R.string.add_button))
            }
        }
    ) { innerPadding ->
        LazyColumn(
            Modifier.fillMaxSize().padding(innerPadding)) {
            items(todos.size) {
                key -> GerenCard(todos.get(key))
            }
        }
    }
}



@Composable
fun Text(
    text: String,
    fontSize: Dp,
    fontWeight: FontWeight,
    color: Long) {
}



@Composable
fun GerenCard(text: String){
    var checkState by remember { mutableStateOf(false) }
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier.padding(20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text,
                modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Center,
                style = if(checkState) TextStyle(textDecoration = TextDecoration.LineThrough) else TextStyle.Default
            )
            Row {
                Checkbox(
                    checked = checkState,
                    onCheckedChange = { checkState = !checkState }
                )
                IconButton(onClick = {}) {
                    Icon(Icons.Default.Delete, stringResource(R.string.description_icon_trash))
                }
            }
            }
        }
    }
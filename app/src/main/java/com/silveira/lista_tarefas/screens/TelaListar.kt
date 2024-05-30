package com.silveira.lista_tarefas.screens

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.navigation.NavController
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.silveira.lista_tarefas.R


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListarTarefas(navController: NavController){
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
                    navController.navigate("SalvarTarefas")
                },
                containerColor = Color(0xFFF9F1F9)
            ) {
                Icon(Icons.Filled.Add, stringResource(id = R.string.add_button))
            }
        }
    ) {}
}

fun Text(
    text: String,
    fontSize: Dp,
    fontWeight: FontWeight,
    color: Long) {

}

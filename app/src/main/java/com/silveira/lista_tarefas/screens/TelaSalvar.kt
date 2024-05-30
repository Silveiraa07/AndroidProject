package com.silveira.lista_tarefas.screens

import android.annotation.SuppressLint
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SalvarTarefas(navController: NavController){
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(Color(0xFFF9F1F9)),
                title = {
                    Text(
                        text = "Criar tarefa",
                        fontSize = 6.dp,
                        fontWeight = FontWeight.Bold,
                        color = 0xFF1D1A20
                    )
                }
            )
        },
        
    )
}
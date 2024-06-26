package com.silveira.lista_tarefas.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.silveira.lista_tarefas.model.Tarefa
import com.silveira.lista_tarefas.repository.TarefaRepository

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SalvarTarefas(navController: NavController){
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(Color(0xFFF9F1F9)),
                title = { Text("List of tasks") }
            )
        },
        content = { PaddingValues ->
            Content()
        }
    )
}

@Composable
fun Content(){
    val localContext = LocalContext.current
    val textState = remember { mutableStateOf("") }

        Column {
            TextField(
                value = textState.value,
                onValueChange = { textState.value = it },
                modifier = Modifier.fillMaxWidth().padding(20.dp,20.dp,20.dp,0.dp),
                label = { Text("Digite a tarefa aqui...") },
                maxLines = 1
            )

            Botao(
                onClick = {
                    val tarefa = Tarefa(
                        id = null,
                        tarefa = String()
                    )
                    val repository = TarefaRepository(localContext)
                    val id = repository.insert(tarefa)
                    Log.i("APPDEBUG",id.toString())
                },
                modifier = Modifier.fillMaxWidth().padding(20.dp).height(80.dp),
                texto = "Salvar",
                color = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFF9F1F9)
                )
            )
        }
}

fun Botao(
    onClick: () -> Unit,
    modifier: Modifier,
    texto: String,
    color: ButtonColors
) = Unit

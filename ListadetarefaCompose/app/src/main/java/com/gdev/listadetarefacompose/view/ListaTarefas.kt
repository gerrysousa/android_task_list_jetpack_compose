package com.gdev.listadetarefacompose.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.gdev.listadetarefacompose.R
import com.gdev.listadetarefacompose.itemlist.TarefaItem
import com.gdev.listadetarefacompose.model.Tarefa
import com.gdev.listadetarefacompose.ui.theme.BLACK
import com.gdev.listadetarefacompose.ui.theme.Purple40
import com.gdev.listadetarefacompose.ui.theme.WHITE

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ListaTarefas(
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Lista de Tarefas",
                        color = WHITE,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Purple40
                )
            )
        },
        containerColor = BLACK,
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("salvarTarefa") },
                containerColor = Purple40,
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_add),
                    contentDescription = "Icone de adicionar tarega"
                )
            }
        }
    ) {
        val listaTarefa: MutableList<Tarefa> = mutableListOf(
            Tarefa(
                tarefa = "Tarefa 0",
                descricao = "Descrição da Tarefa 0",
                prioridade = 0
            ),
            Tarefa(
                tarefa = "Tarefa 1",
                descricao = "Descrição da Tarefa 1",
                prioridade = 1
            ),
            Tarefa(
                tarefa = "Tarefa 2",
                descricao = "Descrição da Tarefa 2",
                prioridade = 2
            ),
            Tarefa(
                tarefa = "Tarefa 3",
                descricao = "Descrição da Tarefa 3",
                prioridade = 3
            ),
        )

        LazyColumn {
            itemsIndexed(listaTarefa) { position, _ ->
                TarefaItem(position, listaTarefa)
            }
        }
    }
}
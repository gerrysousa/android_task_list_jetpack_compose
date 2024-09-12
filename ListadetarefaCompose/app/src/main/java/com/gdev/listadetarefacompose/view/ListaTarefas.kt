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
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.gdev.listadetarefacompose.R
import com.gdev.listadetarefacompose.itemlist.TarefaItem
import com.gdev.listadetarefacompose.model.Tarefa
import com.gdev.listadetarefacompose.repository.TarefasRepository
import com.gdev.listadetarefacompose.ui.theme.BLACK
import com.gdev.listadetarefacompose.ui.theme.Purple40
import com.gdev.listadetarefacompose.ui.theme.WHITE

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ListaTarefas(
    navController: NavController
) {
    val tarefaRepository = TarefasRepository()

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
        val listaTarefas = tarefaRepository.recuperarTarefas().collectAsState(mutableListOf()).value

        LazyColumn {
            itemsIndexed(listaTarefas) { index, _,  ->
                TarefaItem(position =  index, listaTarefa = listaTarefas)
            }

        }
    }
}
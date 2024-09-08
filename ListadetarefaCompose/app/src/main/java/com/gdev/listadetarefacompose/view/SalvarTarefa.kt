package com.gdev.listadetarefacompose.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.gdev.listadetarefacompose.ui.theme.WHITE

@Composable
fun SalvarTarefa(navController: NavController) {
    Text(
        text = "Tela de Salvar Tarefa",
        color = WHITE,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold
    )
}

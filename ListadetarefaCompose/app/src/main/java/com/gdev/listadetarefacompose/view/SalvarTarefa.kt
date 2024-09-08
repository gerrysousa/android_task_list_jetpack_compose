package com.gdev.listadetarefacompose.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.gdev.listadetarefacompose.components.Botao
import com.gdev.listadetarefacompose.components.CaixaDeTexto
import com.gdev.listadetarefacompose.ui.theme.Purple40
import com.gdev.listadetarefacompose.ui.theme.RADIO_BUTTON_GREEN_DISABLE
import com.gdev.listadetarefacompose.ui.theme.RADIO_BUTTON_GREEN_SELECTED
import com.gdev.listadetarefacompose.ui.theme.RADIO_BUTTON_RED_DISABLE
import com.gdev.listadetarefacompose.ui.theme.RADIO_BUTTON_RED_SELECTED
import com.gdev.listadetarefacompose.ui.theme.RADIO_BUTTON_YELLOW_DISABLE
import com.gdev.listadetarefacompose.ui.theme.RADIO_BUTTON_YELLOW_SELECTED
import com.gdev.listadetarefacompose.ui.theme.WHITE

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SalvarTarefa(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Salvar de Tarefa",
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
        containerColor = WHITE,
    ) { scaffoldPadding ->
        @androidx.compose.runtime.Composable {
            Box(modifier = Modifier.padding(scaffoldPadding)) {
                // Fix topbar over content
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(scaffoldPadding)
        ) {
            var tituloTarefa by remember { mutableStateOf("") }
            var decricaoTarefa by remember { mutableStateOf("") }
            var tarefaSemPrioridade by remember { mutableStateOf(false) }
            var tarefaPrioridadeBaixa by remember { mutableStateOf(false) }
            var tarefaPrioridadeMedia by remember { mutableStateOf(false) }
            var tarefaPrioridadeAlta by remember { mutableStateOf(false) }

            CaixaDeTexto(
                value = tituloTarefa,
                onValueChange = {
                    tituloTarefa = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 20.dp, 20.dp, 0.dp),
                label = "Titulo da Tarefa",
                maxLines = 1,
                keyboardType = KeyboardType.Text
            )

            CaixaDeTexto(
                value = decricaoTarefa,
                onValueChange = {
                    decricaoTarefa = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(20.dp, 10.dp, 20.dp, 0.dp),
                label = "Descricao da Tarefa",
                maxLines = 5,
                keyboardType = KeyboardType.Text
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(text = "Nivel de Prioridade")

                RadioButton(
                    selected = tarefaPrioridadeBaixa,
                    onClick = {
                        tarefaPrioridadeBaixa = !tarefaPrioridadeBaixa
                    },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = RADIO_BUTTON_GREEN_SELECTED,
                        unselectedColor = RADIO_BUTTON_GREEN_DISABLE
                    )
                )

                RadioButton(
                    selected = tarefaPrioridadeMedia,
                    onClick = {
                        tarefaPrioridadeMedia = !tarefaPrioridadeMedia
                    },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = RADIO_BUTTON_YELLOW_SELECTED,
                        unselectedColor = RADIO_BUTTON_YELLOW_DISABLE
                    )
                )

                RadioButton(
                    selected = tarefaPrioridadeAlta,
                    onClick = {
                        tarefaPrioridadeAlta = !tarefaPrioridadeAlta
                    },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = RADIO_BUTTON_RED_SELECTED,
                        unselectedColor = RADIO_BUTTON_RED_DISABLE
                    )
                )
            }

            Botao(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .height(80.dp),
                text = "Salvar"
            )
        }
    }
}

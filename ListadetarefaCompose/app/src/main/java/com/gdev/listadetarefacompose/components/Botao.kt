package com.gdev.listadetarefacompose.components

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.gdev.listadetarefacompose.ui.theme.LIGHT_BLUE
import com.gdev.listadetarefacompose.ui.theme.WHITE

@Composable
fun Botao(
    onClick: () -> Unit,
    modifier: Modifier,
    text: String
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = LIGHT_BLUE,
            contentColor = WHITE
        )
    ) {
        Text(text = text, fontWeight = FontWeight.Bold, fontSize = 18.sp)
    }
}
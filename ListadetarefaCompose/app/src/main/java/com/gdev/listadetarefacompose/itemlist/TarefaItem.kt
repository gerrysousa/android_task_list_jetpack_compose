package com.gdev.listadetarefacompose.itemlist

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.gdev.listadetarefacompose.R
import com.gdev.listadetarefacompose.model.Tarefa
import com.gdev.listadetarefacompose.ui.theme.BLACK
import com.gdev.listadetarefacompose.ui.theme.RADIO_BUTTON_GREEN_SELECTED
import com.gdev.listadetarefacompose.ui.theme.RADIO_BUTTON_RED_SELECTED
import com.gdev.listadetarefacompose.ui.theme.RADIO_BUTTON_YELLOW_SELECTED
import com.gdev.listadetarefacompose.ui.theme.ShapeCardPrioridade
import com.gdev.listadetarefacompose.ui.theme.WHITE

@Composable
fun TarefaItem(
    position: Int,
    listaTarefa: MutableList<Tarefa>
) {
    val titulo = listaTarefa[position].titulo
    val descricao = listaTarefa[position].descricao
    val prioridade = listaTarefa[position].prioridade

    var nivelPrioridade = when (prioridade) {
        0 -> "Sem prioridade"
        1 -> "Prioridade Baixa"
        2 -> "Prioridade Media"
        else -> "Prioridade Alta"
    }

    var colorPrioridade = when (prioridade) {
        0 -> BLACK
        1 -> RADIO_BUTTON_GREEN_SELECTED
        2 -> RADIO_BUTTON_YELLOW_SELECTED
        else -> RADIO_BUTTON_RED_SELECTED
    }

    Card(
        colors = CardDefaults.cardColors(containerColor = WHITE),
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
    ) {
        ConstraintLayout(modifier = Modifier.padding(20.dp)) {
            val (txtTarefa, txtDescricao, txtPrioridade, cardPrioridade, btnDeletar) = createRefs()

            Text(
                text = titulo.toString(),
                modifier = Modifier.constrainAs(txtTarefa) {
                    top.linkTo(parent.top, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                }
            )

            Text(
                text = descricao.toString(),
                modifier = Modifier.constrainAs(txtDescricao) {
                    top.linkTo(txtTarefa.bottom, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                }
            )

            Text(
                text = nivelPrioridade,
                modifier = Modifier.constrainAs(txtPrioridade) {
                    top.linkTo(txtDescricao.bottom, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                }
            )

            Card(
                colors = CardDefaults.cardColors(containerColor = colorPrioridade),
                modifier = Modifier
                    .size(30.dp)
                    .constrainAs(cardPrioridade) {
                        top.linkTo(txtDescricao.bottom, margin = 10.dp)
                        start.linkTo(txtPrioridade.end, margin = 10.dp)
                        bottom.linkTo(parent.bottom, margin = 10.dp)
                    },
                shape = ShapeCardPrioridade.large
            ) { }

            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.constrainAs(btnDeletar) {
                    top.linkTo(txtDescricao.bottom, margin = 10.dp)
                    start.linkTo(cardPrioridade.end, margin = 30.dp)
                    end.linkTo(parent.end, margin = 10.dp)
                    bottom.linkTo(parent.bottom, margin = 10.dp)
                }
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_delete),
                    contentDescription = "Icone de deletar"
                )
            }
        }
    }
}

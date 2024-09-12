package com.gdev.listadetarefacompose.repository

import com.gdev.listadetarefacompose.datasource.DataSource

class TarefasRepository {
    private val dataSource= DataSource()

    fun salvarTarefa(tarefa: String, descricao: String, prioridade: Int) {
        dataSource.salvarTarefa(tarefa, descricao, prioridade)
    }
}
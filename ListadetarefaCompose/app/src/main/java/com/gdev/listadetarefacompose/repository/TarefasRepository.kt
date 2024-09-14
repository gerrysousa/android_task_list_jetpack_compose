package com.gdev.listadetarefacompose.repository

import com.gdev.listadetarefacompose.datasource.DataSource
import com.gdev.listadetarefacompose.model.Tarefa
import kotlinx.coroutines.flow.Flow

class TarefasRepository {
    private val dataSource = DataSource()

    fun salvarTarefa(titulo: String, descricao: String, prioridade: Int) {
        dataSource.salvarTarefa(titulo, descricao, prioridade)
    }

    fun recuperarTarefas(): Flow<MutableList<Tarefa>> {
        return dataSource.recuperarTarefas()
    }

    fun deletarTarefa(titulo: String) {
        dataSource.deletarTarefa(titulo)
    }
}
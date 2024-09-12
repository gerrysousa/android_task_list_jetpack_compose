package com.gdev.listadetarefacompose.datasource

import com.gdev.listadetarefacompose.model.Tarefa
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DataSource {
    private val db = FirebaseFirestore.getInstance()
    private val _todasTarefas = MutableStateFlow<MutableList<Tarefa>>(mutableListOf())
    private val todasTarefas: StateFlow<MutableList<Tarefa>> = _todasTarefas

    fun salvarTarefa(titulo: String, descricao: String, prioridade: Int) {
        val tarefaMap = hashMapOf(
            "titulo" to titulo,
            "descricao" to descricao,
            "prioridade" to prioridade
        )

        db.collection("tarefas").document(titulo).set(tarefaMap).addOnCompleteListener {

        }.addOnFailureListener {

        }
    }

    fun recuperarTarefas(): Flow<MutableList<Tarefa>> {

        val listaTarefas: MutableList<Tarefa> = mutableListOf()

        db.collection("tarefas").get().addOnCompleteListener { querySnapshot ->
            if (querySnapshot.isSuccessful) {
                for (document in querySnapshot.result) {
                    val tarefa = document.toObject(Tarefa::class.java)
                    listaTarefas.add(tarefa)
                    _todasTarefas.value = listaTarefas
                }
            }
        }
        return todasTarefas
    }
}
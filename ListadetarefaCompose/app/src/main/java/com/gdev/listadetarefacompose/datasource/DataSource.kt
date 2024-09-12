package com.gdev.listadetarefacompose.datasource

import com.google.firebase.firestore.FirebaseFirestore

class DataSource {
    private val db = FirebaseFirestore.getInstance()

    fun salvarTarefa(tarefa: String, descricao: String, prioridade: Int) {
        val tarefaMap = hashMapOf(
            "titulo" to tarefa,
            "descricao" to descricao,
            "prioridade" to prioridade
        )

        db.collection("tarefas").document(tarefa).set(tarefaMap).addOnCompleteListener {

        }.addOnFailureListener {

        }
    }
}
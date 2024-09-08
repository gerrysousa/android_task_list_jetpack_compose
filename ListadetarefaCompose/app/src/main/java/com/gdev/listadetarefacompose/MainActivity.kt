package com.gdev.listadetarefacompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gdev.listadetarefacompose.ui.theme.ListaDeTarefaComposeTheme
import com.gdev.listadetarefacompose.view.ListaTarefas
import com.gdev.listadetarefacompose.view.SalvarTarefa

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ListaDeTarefaComposeTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "listaTarefas") {
                    composable("listaTarefas") {
                        ListaTarefas(navController)
                    }
                    composable("salvarTarefa") {
                        SalvarTarefa(navController)
                    }

                }
            }
        }
    }
}

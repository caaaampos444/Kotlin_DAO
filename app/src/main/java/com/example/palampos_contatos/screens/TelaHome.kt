package com.example.palampos_contatos.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.palampos_contatos.repository.ContatoRepository

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaHome(controladorDeNavegacao: NavHostController) {

    val cr=ContatoRepository(context = LocalContext.current)
    val contatos=cr.listarTodosOsContatos()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Meus Contatos",
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults
                    .topAppBarColors(
                        containerColor = Color.Magenta
                    )
            )
        },
        bottomBar = {
            BottomAppBar { Text(text = "Barra de rodapé") }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {controladorDeNavegacao.navigate("cadastro")}) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Adicionar contato"
                )
            }
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier.padding(innerPadding)
            ) {
                LazyColumn{
                    items(contatos){
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 8.dp, vertical = 4.dp)
                        ) {
                            Row{
                                Column(
                                    modifier = Modifier.padding(8.dp)
                                ) {
                                    Text(text = it.nome)
                                    Text(text = it.email)
                                }
                            }
                        }
                    }
                }
            }
        }
    )
}
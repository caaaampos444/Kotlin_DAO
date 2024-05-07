package com.example.palampos_contatos.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.palampos_contatos.R
import com.example.palampos_contatos.model.Contato
import com.example.palampos_contatos.repository.ContatoRepository
import com.example.palampos_contatos.ui.theme.Palampos_contatosTheme

@Composable
fun FormularioContatos(controladorDeNavegacao: NavHostController) {

    var nomeState = remember {
        mutableStateOf("")
    }
    var emailState = remember {
        mutableStateOf("")
    }
    var foneState = remember {
        mutableStateOf("")
    }
    var dataNascimentoState = remember {
        mutableStateOf("")
    }
    var isAmigoState = remember {
        mutableStateOf(false)
    }

    val cr = ContatoRepository(LocalContext.current)

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = stringResource(id = R.string.title_new_contact),
        )
        OutlinedTextField(
            value = nomeState.value,
            onValueChange = {
                nomeState.value=it
            },
            label = {
                Text(text = stringResource(id = R.string.contact_name))
            },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = emailState.value,
            onValueChange = {
                emailState.value=it
            },
            label = {
                Text(text = stringResource(id = R.string.contact_email))
            },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = foneState.value,
            onValueChange = {
                foneState.value=it
            },
            label = {
                Text(text = stringResource(id = R.string.contact_phone))
            },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = dataNascimentoState.value,
            onValueChange = {
                dataNascimentoState.value=it
            },
            label = {
                Text(text = stringResource(id = R.string.contact_birth))
            },
            modifier = Modifier.fillMaxWidth()
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(checked = isAmigoState.value, onCheckedChange = {
                isAmigoState.value=it
            })
            Text(text = stringResource(id = R.string.contact_friend))
        }
        Button(
            onClick = {
                val contato = Contato(
                    nome = nomeState.value,
                    email = emailState.value,
                    telefone = foneState.value,
                    isAmigo = isAmigoState.value
                )
                cr.salvar(contato)
                controladorDeNavegacao.navigate("home")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(id = R.string.button_text))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    Palampos_contatosTheme {
    }
}
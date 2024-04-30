package com.example.palampos_contatos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.palampos_contatos.ui.theme.Palampos_contatosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Palampos_contatosTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FormularioContatos()
                }
            }
        }
    }
}

@Composable
fun FormularioContatos() {

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
            onClick = { /*TODO*/ },
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
        FormularioContatos()
    }
}
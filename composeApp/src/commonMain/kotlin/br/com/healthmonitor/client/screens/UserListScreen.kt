package br.com.healthmonitor.client.screens

import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.healthmonitor.client.models.User
import br.com.healthmonitor.client.network.ApiService

@Composable
fun UserListScreen() {
    var users by remember { mutableStateOf<List<User>>(emptyList()) }
    var error by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(Unit) {
        try {
            users = ApiService().getUsers()
        } catch (e: Exception) {
            error = e.message ?: "Erro desconhecido"
        }
    }

    Column(Modifier.padding(16.dp)) {
        Text("Lista de Usuários", style = MaterialTheme.typography.titleLarge)

        if (error != null) {
            Text("Erro: $error", color = MaterialTheme.colorScheme.error)
        } else {
            users.forEach {
                Text("${it.name} - ${it.email}")
            }
        }
    }
}

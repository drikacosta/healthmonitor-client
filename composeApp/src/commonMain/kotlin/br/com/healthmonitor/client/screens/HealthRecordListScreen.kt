package br.com.healthmonitor.client.screens

import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.healthmonitor.client.models.HealthRecord
import br.com.healthmonitor.client.network.ApiService

@Composable
fun HealthRecordListScreen() {
    var records by remember { mutableStateOf<List<HealthRecord>>(emptyList()) }
    var error by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(Unit) {
        try {
            records = ApiService().getHealthRecords()
        } catch (e: Exception) {
            error = e.message ?: "Erro desconhecido"
        }
    }

    Column(Modifier.padding(16.dp)) {
        Text("Lista de Registros de Saúde", style = MaterialTheme.typography.titleLarge)

        if (error != null) {
            Text("Erro: $error", color = MaterialTheme.colorScheme.error)
        } else {
            records.forEach {
                Text("${it.type}: ${it.value} (User ID: ${it.userId})")
            }
        }
    }
}

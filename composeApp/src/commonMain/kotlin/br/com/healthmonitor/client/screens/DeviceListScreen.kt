package br.com.healthmonitor.client.screens

import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.healthmonitor.client.models.Device
import br.com.healthmonitor.client.network.ApiService

@Composable
fun DeviceListScreen() {
    var devices by remember { mutableStateOf<List<Device>>(emptyList()) }
    var error by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(Unit) {
        try {
            devices = ApiService().getDevices()
        } catch (e: Exception) {
            error = e.message ?: "Erro desconhecido"
        }
    }

    Column(Modifier.padding(16.dp)) {
        Text("Lista de Dispositivos", style = MaterialTheme.typography.titleLarge)

        if (error != null) {
            Text("Erro: $error", color = MaterialTheme.colorScheme.error)
        } else {
            devices.forEach {
                Text("${it.name} (User ID: ${it.userId})")
            }
        }
    }
}

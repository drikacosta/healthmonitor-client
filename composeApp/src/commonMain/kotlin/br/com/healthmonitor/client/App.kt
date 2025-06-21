package br.com.healthmonitor.client

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import br.com.healthmonitor.client.screens.*
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height


@Composable
fun App() {
    MaterialTheme {
        var screen by remember { mutableStateOf("menu") }

        when (screen) {
            "menu" -> Column(Modifier.padding(16.dp)) {
                Text("HealthMonitor Client", style = MaterialTheme.typography.titleLarge)
                Spacer(Modifier.height(8.dp))
                Button(onClick = { screen = "users" }) { Text("Ver Usuários") }
                Button(onClick = { screen = "devices" }) { Text("Ver Dispositivos") }
                Button(onClick = { screen = "records" }) { Text("Ver Registros de Saúde") }
            }

            "users" -> UserListScreen()
            "devices" -> DeviceListScreen()
            "records" -> HealthRecordListScreen()
        }
    }
}
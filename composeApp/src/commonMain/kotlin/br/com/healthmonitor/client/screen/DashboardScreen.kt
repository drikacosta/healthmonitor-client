package br.com.healthmonitor.client.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DashboardScreen(onAddMeasurement: () -> Unit, onViewReport: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("CardiON", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(16.dp))
        Button(onClick = onAddMeasurement, modifier = Modifier.fillMaxWidth()) { Text("Adicionar Medição") }
        Spacer(Modifier.height(8.dp))
        Button(onClick = onViewReport, modifier = Modifier.fillMaxWidth()) { Text("Relatório Semanal") }
    }
}

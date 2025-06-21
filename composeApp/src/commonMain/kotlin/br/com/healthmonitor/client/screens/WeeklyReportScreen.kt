package br.com.healthmonitor.client.screens

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
fun WeeklyReportScreen(onBackClick: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Relatório Semanal", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(16.dp))
        Text("Frequência Cardíaca: -- bpm")
        Text("Pressão Arterial: -- mmHg")
        Text("Glicemia: -- mg/dL")

        Spacer(Modifier.height(16.dp))
        Button(onClick = onBackClick, modifier = Modifier.fillMaxWidth()) { Text("Voltar") }
    }
}

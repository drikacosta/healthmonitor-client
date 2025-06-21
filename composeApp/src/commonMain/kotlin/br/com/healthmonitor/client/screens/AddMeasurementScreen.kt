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
fun AddMeasurementScreen(onBackClick: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Adicionar Medições", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(16.dp))
        Button(onClick = { /* ação pressão arterial */ }, modifier = Modifier.fillMaxWidth()) { Text("Adicionar Pressão Arterial") }
        Spacer(Modifier.height(8.dp))
        Button(onClick = { /* ação glicemia */ }, modifier = Modifier.fillMaxWidth()) { Text("Adicionar Glicemia") }
        Spacer(Modifier.height(8.dp))
        Button(onClick = onBackClick, modifier = Modifier.fillMaxWidth()) { Text("Voltar") }
    }
}

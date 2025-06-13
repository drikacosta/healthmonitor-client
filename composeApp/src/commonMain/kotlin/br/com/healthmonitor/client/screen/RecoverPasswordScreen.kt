package br.com.healthmonitor.client.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
fun RecoverPasswordScreen(onRecoverSuccess: () -> Unit, onBackClick: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Recuperar Senha", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(24.dp))

        var code by remember { mutableStateOf("") }

        OutlinedTextField(
            value = code,
            onValueChange = { code = it },
            label = { Text("Código de 4 dígitos") }
        )

        Spacer(Modifier.height(16.dp))
        Button(
            onClick = onRecoverSuccess,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Enviar")
        }
        TextButton(onClick = onBackClick) {
            Text("Voltar")
        }
    }
}

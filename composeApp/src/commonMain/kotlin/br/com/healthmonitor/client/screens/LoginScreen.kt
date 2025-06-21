package br.com.healthmonitor.client.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    onRegisterClick: () -> Unit,
    onRecoverClick: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("CardiON", fontSize = 32.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(32.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Senha") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = onLoginSuccess,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Entrar")
        }

        Spacer(Modifier.height(8.dp))

        SimpleTextButton(text = "Esqueceu sua senha?", onClick = onRecoverClick)
        SimpleTextButton(text = "Não possui Cadastro? Registre-se", onClick = onRegisterClick)
    }
}

@Composable
fun SimpleTextButton(text: String, onClick: () -> Unit) {
    Text(
        text = text,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier
            .padding(vertical = 8.dp)
            .clickable { onClick() }
    )
}

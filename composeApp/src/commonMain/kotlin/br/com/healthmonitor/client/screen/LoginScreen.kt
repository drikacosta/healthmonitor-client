package br.com.healthmonitor.client.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.reflect.KProperty

@Composable
fun LoginScreen(onLoginSuccess: () -> Unit, onRegisterClick: () -> Unit, onRecoverClick: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.Center) {
        Text("CardiON", fontSize = 32.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(32.dp))

        val emailState = remember { mutableStateOf("") }
        val passwordState = remember { mutableStateOf("") }

        OutlinedTextField(
            value = emailState.value,
            onValueChange = { emailState.value = it },
            label = { Text("Email") }
        )

        OutlinedTextField(
            value = passwordState.value,
            onValueChange = { passwordState.value = it },
            label = { Text("Senha") },
            visualTransformation = PasswordVisualTransformation()
        )


        Spacer(Modifier.height(16.dp))
        Button(onClick = onLoginSuccess, modifier = Modifier.fillMaxWidth()) { Text("Entrar") }
        TextButton(onClick = onRecoverClick) { Text("Esqueceu sua senha?") }
        TextButton(onClick = onRegisterClick) { Text("Não possui Cadastro? Registre-se") }
    }
}

private operator fun Any.getValue(nothing: Nothing?, property: KProperty<*>) {
}

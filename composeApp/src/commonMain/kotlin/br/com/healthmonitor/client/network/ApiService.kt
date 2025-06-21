package br.com.healthmonitor.client.network

import br.com.healthmonitor.client.models.Device
import br.com.healthmonitor.client.models.HealthRecord
import br.com.healthmonitor.client.models.User
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import io.ktor.http.*

class ApiService {

    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                isLenient = true
            })
        }
    }


    private val baseUrl = "http://10.0.2.2:8080"

    suspend fun getUsers(): List<User> {
        return client.get("$baseUrl/users").body()
    }

    suspend fun getDevices(): List<Device> {
        return client.get("$baseUrl/devices").body()
    }

    suspend fun getHealthRecords(): List<HealthRecord> {
        return client.get("$baseUrl/healthrecords").body()
    }
}
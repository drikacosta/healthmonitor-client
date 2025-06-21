package br.com.healthmonitor.client.models

import kotlinx.serialization.Serializable

@Serializable
data class HealthRecord(
    val id: Long,
    val userId: Long,
    val type: String,
    val value: String
)

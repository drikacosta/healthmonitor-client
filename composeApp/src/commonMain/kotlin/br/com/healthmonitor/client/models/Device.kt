package br.com.healthmonitor.client.models

import kotlinx.serialization.Serializable

@Serializable
data class Device(
    val id: Long,
    val name: String,
    val userId: Long
)
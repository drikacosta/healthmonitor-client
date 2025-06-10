package br.com.healthmonitor.client

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
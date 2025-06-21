plugins {
    kotlin("multiplatform") version "2.1.21"
    id("org.jetbrains.kotlin.plugin.compose") version "2.1.21"
    id("org.jetbrains.compose") version "1.8.1"
    id("com.android.library")
    kotlin("plugin.serialization") version "2.1.21"
}

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

kotlin {
    androidTarget()
    jvm("desktop")

    js(IR) {
        browser()
        binaries.executable()
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")

                // Ktor comum
                implementation(libs.ktor.client.core)
                implementation(libs.ktor.client.content.negotiation)
                implementation(libs.ktor.serialization.kotlinx.json)
            }
        }

        val androidMain by getting {
            dependencies {
                implementation("androidx.activity:activity-compose:1.8.0")
                implementation("androidx.compose.material3:material3:1.2.0")
                implementation("androidx.compose.ui:ui-tooling-preview:1.5.0")

                implementation("io.ktor:ktor-client-okhttp:2.3.4")
                implementation("io.ktor:ktor-client-content-negotiation:2.3.4")
                implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.4")
                implementation("io.ktor:ktor-client-logging:2.3.4")

                // Firebase Crashlytics Android
                implementation("com.google.firebase:firebase-crashlytics-ktx:18.4.1")
            }
        }

        val desktopMain by getting {
            dependencies {
                implementation(compose.desktop.currentOs)

                implementation("io.ktor:ktor-client-cio:2.3.4")
                implementation("io.ktor:ktor-client-content-negotiation:2.3.4")
                implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.4")
                implementation("io.ktor:ktor-client-logging:2.3.4")

                implementation("androidx.collection:collection:1.4.0")
            }
        }

        val jsMain by getting {
            dependencies {
                implementation(compose.web.core)
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)

                implementation("io.ktor:ktor-client-js:2.3.4")
                implementation("io.ktor:ktor-client-content-negotiation:2.3.4")
                implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.4")
                implementation("io.ktor:ktor-client-logging:2.3.4")
            }
        }
    }
}

android {
    namespace = "br.com.healthmonitor.client"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
}

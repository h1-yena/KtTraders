val ktor_version: String by project

plugins {
    kotlin("jvm") version "2.2.0"
    id("org.jetbrains.kotlin.plugin.serialization") version "2.2.0"

    application

}
application {
    mainClass = "tanuki.ktraders.main.behavior.MainKt"
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }

}

kotlin {
    jvmToolchain(21)

}


group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    implementation("io.ktor:ktor-client-core:${ktor_version}")
    implementation("io.ktor:ktor-client-cio:${ktor_version}")
    implementation("io.ktor:ktor-client-content-negotiation:${ktor_version}")
    implementation("io.ktor:ktor-serialization-kotlinx-json:${ktor_version}")

    // Please no more vulnerabilities! D:
    implementation("org.apache.logging.log4j:log4j-slf4j2-impl:2.25.0")

    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.7.0")
}

tasks.test {
    useJUnitPlatform()
}
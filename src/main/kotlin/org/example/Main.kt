package org.example

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.apache.logging.log4j.LogManager

suspend fun main() {

    LogManager.getLogger()

    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
            })
        }
    }

    val response: HttpResponse = client.get("https://api.spacetraders.io/v2")


    val spaceTraderInfo: SpaceTradersInfo = response.body()

    println(spaceTraderInfo)

}
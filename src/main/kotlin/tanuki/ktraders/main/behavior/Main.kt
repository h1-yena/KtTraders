package tanuki.ktraders.main.behavior

import io.ktor.client.*
import io.ktor.client.call.body
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpMethod
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import java.io.File

private var secret: String = ""

suspend fun main() {

    secret = loadSecret()


    val client = initializeHttpClient()
    val pretty = Json { prettyPrint = true }

    val response: HttpResponse = client.request("https://api.spacetraders.io/v2/my/ships") {

        method = HttpMethod.Get
        headers.append("Content-Type", "application/json")
        headers.append("Authorization", "Bearer $secret")

    }

    println(response.body<String>())
}

private fun initializeHttpClient(): HttpClient {
    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
            })
        }
    }
    return client
}

private fun loadSecret(): String {
    val secretsFile: File = File("token.txt")
    return secretsFile.inputStream().readBytes().toString(Charsets.UTF_8)

}
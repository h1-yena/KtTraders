package tanuki.ktraders.main.behavior

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import tanuki.ktraders.main.structure.SpaceTradersInfo
import java.io.File

suspend fun main() {

    val secretsFile: File = File("token.txt")

    if (secretsFile.isFile) println("File for secrets exists at path: " + secretsFile.absolutePath)

    val fileSecret = secretsFile.inputStream().readBytes().toString(Charsets.UTF_8)

    println(secretsFile.inputStream().readNBytes(2).toString(Charsets.UTF_8))

    println("The following secret was contained in that file: $fileSecret")

    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
            })
        }
    }
    val pretty = Json { prettyPrint = true }
    val response: HttpResponse = client.get("https://api.spacetraders.io/v2")


    val spaceTraderInfo: SpaceTradersInfo = response.body()

    println(pretty.encodeToString(spaceTraderInfo))

}
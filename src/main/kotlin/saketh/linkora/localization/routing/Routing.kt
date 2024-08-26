package saketh.linkora.localization.routing

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement
import saketh.linkora.localization.routing.model.info.Info
import saketh.linkora.localization.routing.model.info.Language

fun Application.configureRouting() {
    val localizedStrings = LocalizedStrings()
    routing {
        get("/") {
            call.respondRedirect("https://github.com/sakethpathike/Linkora")
        }
        get("/info") {
            call.respond(
                Json.encodeToJsonElement<Info>(
                    Info(
                        totalAvailableLanguages = 2, availableLanguages = listOf(
                            Language(
                                languageName = "English",
                                languageCode = "en",
                                localizedStringsCount = 249,
                                contributionLink = ""
                            ),
                            Language(
                                languageName = "हिंदी",
                                languageCode = "hi",
                                localizedStringsCount = 200,
                                contributionLink = ""
                            ),
                        ),
                        totalStrings = 249,
                        lastUpdatedOn = "24-08-2024"
                    )
                )
            )
        }

        get(Route.ENGLISH.route) {
            call.respondText(localizedStrings.retrieveLocalizedStrings(Route.ENGLISH))
        }

        get(Route.HINDI.route) {
            call.respondText(localizedStrings.retrieveLocalizedStrings(Route.HINDI))
        }
    }
}


class LocalizedStrings {
    fun retrieveLocalizedStrings(languageCode: Route): String {
        val file = this::class.java.getResourceAsStream("/raw/${languageCode.route.substringAfter("/")}.txt")
        return file.use { it?.bufferedReader()?.readText().toString() }
    }
}

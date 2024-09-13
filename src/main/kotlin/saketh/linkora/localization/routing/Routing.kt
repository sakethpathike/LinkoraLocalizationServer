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
                                localizedStringsCount = 285,
                                contributionLink = ""
                            ),
                            Language(
                                languageName = "हिंदी",
                                languageCode = "hi",
                                localizedStringsCount = 285,
                                contributionLink = ""
                            ),
                            Language(
                                languageName = "اَلْعَرَبِيَّةُ",
                                languageCode = "arabic",
                                localizedStringsCount = 263,
                                contributionLink = "https://crowdin.com/editor/linkora/2/en-ar?filter=basic&value=0"
                            ),
                            Language(
                                languageName = "polski",
                                languageCode = "polish",
                                localizedStringsCount = 38,
                                contributionLink = "https://crowdin.com/editor/linkora/2/en-pl?filter=basic&value=0"
                            ),
                            Language(
                                languageName = "русский",
                                languageCode = "russian",
                                localizedStringsCount = 54,
                                contributionLink = "https://crowdin.com/editor/linkora/2/en-ru?filter=basic&value=0"
                            ),
                            Language(
                                languageName = "Português Brasileiro",
                                languageCode = "portuguese_brazilian",
                                localizedStringsCount = 102,
                                contributionLink = "https://crowdin.com/editor/linkora/2/en-ptbr?filter=basic&value=0"
                            ),
                        ), totalStrings = 285, lastUpdatedOn = "13-09-2024::07:08 PM"
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

        get(Route.ARABIC.route) {
            call.respondText(localizedStrings.retrieveLocalizedStrings(Route.ARABIC))
        }
        get(Route.POLISH.route) {
            call.respondText(localizedStrings.retrieveLocalizedStrings(Route.POLISH))
        }
        get(Route.PORTUGUESE_BRAZILIAN.route) {
            call.respondText(localizedStrings.retrieveLocalizedStrings(Route.PORTUGUESE_BRAZILIAN))
        }
        get(Route.RUSSIAN.route) {
            call.respondText(localizedStrings.retrieveLocalizedStrings(Route.RUSSIAN))
        }
    }
}


class LocalizedStrings {
    fun retrieveLocalizedStrings(languageCode: Route): String {
        val file = this::class.java.getResourceAsStream("/raw/${languageCode.route.substringAfter("/")}.txt")
        return file.use { it?.bufferedReader()?.readText().toString() }
    }
}

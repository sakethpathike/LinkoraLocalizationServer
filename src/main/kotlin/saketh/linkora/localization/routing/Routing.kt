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
                        totalAvailableLanguages = 8, availableLanguages = listOf(
                            Language(
                                languageName = "English",
                                languageCode = "en",
                                localizedStringsCount = 303,
                                contributionLink = ""
                            ),
                            Language(
                                languageName = "हिंदी",
                                languageCode = "hi",
                                localizedStringsCount = 303,
                                contributionLink = ""
                            ),
                            Language(
                                languageName = "اَلْعَرَبِيَّةُ",
                                languageCode = "arabic", // translated by https://crowdin.com/profile/muhammadbahaa2001
                                localizedStringsCount = 263,
                                contributionLink = "https://crowdin.com/editor/linkora/2/en-ar?filter=basic&value=0"
                            ),
                            Language(
                                languageName = "polski",
                                languageCode = "polish", // translated by https://crowdin.com/profile/sbezel
                                localizedStringsCount = 38,
                                contributionLink = "https://crowdin.com/editor/linkora/2/en-pl?filter=basic&value=0"
                            ),
                            Language(
                                languageName = "русский",
                                languageCode = "russian", // translated by https://crowdin.com/profile/antonov04.nk
                                localizedStringsCount = 54,
                                contributionLink = "https://crowdin.com/editor/linkora/2/en-ru?filter=basic&value=0"
                            ),
                            Language(
                                languageName = "Português Brasileiro",
                                languageCode = "portuguese_brazilian", // translated by https://crowdin.com/profile/lucmsilva
                                localizedStringsCount = 102,
                                contributionLink = "https://crowdin.com/editor/linkora/2/en-ptbr?filter=basic&value=0"
                            ),
                            Language(
                                languageName = "español",
                                languageCode = "spanish", // translated by https://crowdin.com/profile/santillompart, https://crowdin.com/profile/jcba3z
                                localizedStringsCount = 303,
                                contributionLink = ""
                            ),
                            Language(
                                languageName = "français",
                                languageCode = "french",
                                localizedStringsCount = 303,
                                contributionLink = ""
                            ),
                        ), totalStrings = 303, lastUpdatedOn = "29-09-2024::03:00 PM IST"
                    )
                )
            )
        }

        Route.entries.forEach { entry ->
            get(entry.route) {
                call.respondText(localizedStrings.retrieveLocalizedStrings(entry))
            }
        }

    }
}


class LocalizedStrings {
    fun retrieveLocalizedStrings(languageCode: Route): String {
        val file = this::class.java.getResourceAsStream("/raw/${languageCode.route.substringAfter("/")}.txt")
        return file.use { it?.bufferedReader()?.readText().toString() }
    }
}

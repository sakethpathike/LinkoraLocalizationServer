package saketh.linkora.localization.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import saketh.linkora.localization.Route
import java.io.File

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondRedirect("https://github.com/sakethpathike/Linkora")
        }

        get(Route.ENGLISH.route) {
            call.respondText(retrieveLocalizedStrings(Route.ENGLISH))
        }

        get(Route.HINDI.route) {
            call.respondText(retrieveLocalizedStrings(Route.HINDI))
        }
    }
}


private fun retrieveLocalizedStrings(languageCode: Route): String {
    val enFile = File("src/main/resources/raw/${languageCode.route.substringAfter("/")}.xml")
    return enFile.readText()
}
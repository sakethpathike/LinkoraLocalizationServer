package saketh.linkora.localization.plugins

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import jdk.jfr.internal.JVM
import saketh.linkora.localization.Route
import java.io.File

fun Application.configureRouting() {
    val localizedStrings = LocalizedStrings()
    routing {
        get("/") {
            call.respondRedirect("https://github.com/sakethpathike/Linkora")
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
        val file =
            this::class.java.getResourceAsStream("/raw/${languageCode.route.substringAfter("/")}.xml")
        return file.use { it?.bufferedReader()?.readText().toString() }
    }
}

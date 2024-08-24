package saketh.linkora.localization.routing.model.info

import kotlinx.serialization.Serializable

@Serializable
data class Language(
    val languageName: String,
    val languageCode: String,
    val localizedStringsCount: Int,
    val contributionLink: String
)

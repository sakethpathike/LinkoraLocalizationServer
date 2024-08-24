package saketh.linkora.localization.routing.model.info

import kotlinx.serialization.Serializable

@Serializable
data class Info(
    val totalAvailableLanguages: Int,
    val availableLanguages: List<Language>,
    val totalStrings: Int,
    val lastUpdatedOn: String
)

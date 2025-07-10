package org.example

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonIgnoreUnknownKeys

@Serializable
@JsonIgnoreUnknownKeys
data class SpaceTradersInfo(
    val status: String,
    val version: String,
    val resetDate: String,
    val description: String,
    val stats: Map<String, Int>
)

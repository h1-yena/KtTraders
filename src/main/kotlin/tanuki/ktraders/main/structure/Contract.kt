package tanuki.ktraders.main.structure

import kotlinx.serialization.Serializable
import kotlin.time.TimeMark

@Serializable
data class Contract(
    val id: String,
    val factionSymbol: String,
    val type: Procurement,
    val terms: ContractTerms,
    val accepted: Boolean,
    val fulfilled: Boolean,
    val deadlineToAccept: TimeMark
)

package tanuki.ktraders.main.structure

import kotlinx.serialization.Serializable
import kotlin.time.TimeMark


@Serializable
data class ContractTerms(
    val deadline: TimeMark,
    val payment: Payment,
    val delivery: Delivery
)

package tanuki.ktraders.main.structure

import kotlinx.serialization.Serializable

@Serializable
data class Payment(
    val onAccepted: Int,
    val onFulfilled: Int
)

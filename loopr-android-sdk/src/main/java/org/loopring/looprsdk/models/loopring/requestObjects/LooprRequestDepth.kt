package org.loopring.looprsdk.models.loopring.requestObjects

data class LooprRequestDepth(
        val market: String,
        val delegateAddress: String,
        val length: Int
)
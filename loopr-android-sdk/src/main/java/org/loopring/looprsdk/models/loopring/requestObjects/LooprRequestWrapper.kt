package org.loopring.looprsdk.models.loopring.requestObjects

data class LooprRequestWrapper(
        val jsonrpc: String,
        val method: String,
        val paramObj: Any,
        val id: Int
) {
    val params: List<Any> = listOf(paramObj)
}
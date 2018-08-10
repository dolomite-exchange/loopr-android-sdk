package org.loopring.looprsdk.models.loopring.responseObjects

import com.google.gson.*


import java.lang.reflect.Type

class LooprBalance(
        override var id: Int? = null, override var jsonrpc: String? = null
) : LooprResponse {

    /**
     * The loopring TokenTransferDelegate Protocol
     * Example output - "0x5567ee920f7E62274284985D793344351A00142B"
     */
    var delegateAddress : String? = null

    /**
     * List of [LooprTokenInfo] objects with information about the token
     */
    var tokens : ArrayList<LooprTokenInfo>? = null

    /**
     * Custom class deserializer
     */
    class LooprBalanceDeserializer : JsonDeserializer<LooprBalance> {
        @Throws(JsonParseException::class)
        override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): LooprBalance? {
            if (json.isJsonNull || json.isJsonPrimitive) {
                return null
            } else {
                val jsonObj = json.asJsonObject
                val balanceInfo = LooprBalance()

                LooprResponse.checkForError(jsonObj)
                balanceInfo.setIdJsonRPC(jsonObj)

                //TODO - check if this code is enough to handle normally encountered errors
                jsonObj.get("result")?.let {
                    balanceInfo.delegateAddress = it.asJsonObject.get("delegateAddress").asString
                    val tokenArray = it.asJsonObject.get("tokens").asJsonArray

                    balanceInfo.tokens = ArrayList()
                    tokenArray.forEach {
                        balanceInfo.tokens?.add(context.deserialize(it, LooprTokenInfo::class.java))
                    }
                }
                return balanceInfo
            }
        }

    }
}
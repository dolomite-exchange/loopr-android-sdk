package org.loopring.looprsdk.models.loopring.responseObjects

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import com.google.gson.annotations.SerializedName


import java.lang.reflect.Type

class LooprMarketPairs(
        override var id: Int? = null, override var jsonrpc: String? = null
) : LooprResponse {

    /**
     * The array of all supported markets
     * Example output -  ["SAN-WETH","GNO-WETH","RLC-WETH","AST-WETH"]
     */
    @SerializedName("result")
    var pairs: ArrayList<String>? = null

    /**
     * Custom class deserializer
     */
    class LooprMarketPairsDeserializer : JsonDeserializer<LooprMarketPairs> {
        @Throws(JsonParseException::class)
        override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): LooprMarketPairs? {
            if (json.isJsonNull || json.isJsonPrimitive) {
                return null
            } else {
                val jsonObj = json.asJsonObject
                val marketPairsObj = LooprMarketPairs()

                LooprResponse.checkForError(jsonObj)
                marketPairsObj.setIdJsonRPC(jsonObj)

                //TODO - check if this code is enough to handle normally encountered errors
                jsonObj.get("result")?.let {
                    marketPairsObj.pairs = ArrayList()
                    it.asJsonArray.forEach {
                        marketPairsObj.pairs?.add(it.asString)
                    }
                }

                return marketPairsObj
            }
        }

    }
}
package org.loopring.looprsdk.models.loopring.responseObjects

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import com.google.gson.annotations.SerializedName


import java.lang.reflect.Type

class LooprPriceQuote(
        override var id: Int? = null, override var jsonrpc: String? = null
) : LooprResponse {

    /**
     * The base currency, CNY or USD
     * Example output - "CNY"
     */
    @SerializedName("currency")
    var currency: String? = null

    /**
     * Every token price int the currency
     */
    var tokens: ArrayList<LooprTokenPriceQuote>? = null

    /**
     * Custom class deserializer
     */
    class LooprPriceQuoteDeserializer : JsonDeserializer<LooprPriceQuote> {
        @Throws(JsonParseException::class)
        override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): LooprPriceQuote? {
            if (json.isJsonNull || json.isJsonPrimitive) {
                return null
            } else {
                val jsonObj = json.asJsonObject
                val priceQuote = LooprPriceQuote()

                LooprResponse.checkForError(jsonObj)
                priceQuote.setIdJsonRPC(jsonObj)

                //TODO - check if this code is enough to handle normally encountered errors
                jsonObj.get("result")?.let {
                    it.asJsonObject.get("currency")?.let {
                        priceQuote.currency = it.asString
                    }

                    val tokensJsonArray = it.asJsonObject.get("tokens").asJsonArray

                    priceQuote.tokens = ArrayList()
                    tokensJsonArray.forEach {
                        priceQuote.tokens?.add(context.deserialize(it, LooprTokenPriceQuote::class.java))
                    }
                }

                return priceQuote
            }
        }

    }

}
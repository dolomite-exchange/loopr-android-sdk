package org.loopring.looprsdk.models.loopring.responseObjects

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException


import java.lang.reflect.Type


class LooprTickerExchangeList(
        override var id: Int? = null, override var jsonrpc: String? = null
) : LooprResponse {

    /**
     * Ticker results from various exchanges
     */
    var tickers: ArrayList<LooprTicker>? = null

    /**
     * Custom class deserializer
     */
    class LooprTickerExchangeListDeserializer : JsonDeserializer<LooprTickerExchangeList> {
        @Throws(JsonParseException::class)
        override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): LooprTickerExchangeList? {
            if (json.isJsonNull || json.isJsonPrimitive) {
                return null
            } else {
                val jsonObj = json.asJsonObject
                val tickerList = LooprTickerExchangeList()

                LooprResponse.checkForError(jsonObj)
                tickerList.setIdJsonRPC(jsonObj)

                //TODO - check if this code is enough to handle normally encountered errors
                jsonObj.get("result")?.let {
                    val tickerJsonObject = it.asJsonObject
                    tickerList.tickers = ArrayList()

                    //TODO - this one is missing 'market' so LooprTicker may fail deserialization. Find out through testing
                    for (exchange in tickerJsonObject.keySet()) {
                        tickerList.tickers?.add(context.deserialize(tickerJsonObject.get(exchange).asJsonObject, LooprTicker::class.java))
                    }
                }

                return tickerList
            }
        }

    }
}
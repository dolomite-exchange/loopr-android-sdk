package org.loopring.looprsdk.models.loopring.responseObjects

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import java.lang.reflect.Type

class LooprTickerList(
        override var id: Int? = null, override var jsonrpc: String? = null
) : LooprResponse {

    /**
     * Ticker results from various exchanges
     */
    var tickers: ArrayList<LooprTicker>? = null

    /**
     * Custom class deserializer
     */
    class LooprTickerListDeserializer : JsonDeserializer<LooprTickerList> {
        @Throws(JsonParseException::class)
        override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): LooprTickerList? {
            if (json.isJsonNull || json.isJsonPrimitive) {
                return null
            } else {
                val jsonObj = json.asJsonObject
                val tickerList = LooprTickerList()

                LooprResponse.checkForError(jsonObj)
                tickerList.setIdJsonRPC(jsonObj)

                //TODO - check if this code is enough to handle normally encountered errors
                jsonObj.get("result")?.let {
                    val tickerJsonArray = it.asJsonArray

                    tickerList.tickers = ArrayList()
                    tickerJsonArray.forEach {
                        tickerList.tickers?.add(context.deserialize(it, LooprTicker::class.java))
                    }
                }

                return tickerList

            }
        }

    }
}
package org.loopring.looprsdk.models.loopring.responseObjects

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import com.google.gson.annotations.SerializedName


import java.lang.reflect.Type

class LooprDepth(
        override var id: Int? = null, override var jsonrpc: String? = null
) : LooprResponse {

    /**
     * List of [LooprDepthListItem] each with information about the buy demand at certain price depths
     */
    var buyDepth: ArrayList<LooprDepthListItem>? = null

    /**
     * List of [LooprDepthListItem] each with information about the sell demand at certain price depths
     */
    var sellDepth: ArrayList<LooprDepthListItem>? = null

    /**
     * The market pair
     * Example output - "LRC-ETH"
     */
    @SerializedName("market")
    var market: String? = null

    /**
     * The loopring protocol version
     * Example output - "v1.2"
     */
    @SerializedName("delegateAddress")
    var delegateAddress: String? = null

    /**
     * Custom class deserializer
     */
    class LooprDepthDeserializer : JsonDeserializer<LooprDepth> {
        @Throws(JsonParseException::class)
        override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): LooprDepth? {
            if (json.isJsonNull || json.isJsonPrimitive) {
                return null
            } else {
                val jsonObj = json.asJsonObject
                val depthObj = LooprDepth()

                LooprResponse.checkForError(jsonObj)
                depthObj.setIdJsonRPC(jsonObj)

                jsonObj.get("result")?.let {
                    val depthLists = it.asJsonObject.get("depth").asJsonObject

                    depthLists.get("buy")?.let {
                        depthObj.buyDepth = ArrayList()
                        it.asJsonArray.forEach {
                            depthObj.buyDepth?.add(context.deserialize(it, LooprDepthListItem::class.java))
                        }
                    }

                    depthLists.get("sell")?.let {
                        depthObj.sellDepth = ArrayList()
                        it.asJsonArray.forEach {
                            depthObj.sellDepth?.add(context.deserialize(it, LooprDepthListItem::class.java))
                        }
                    }

                    it.asJsonObject?.get("market")?.let {
                        depthObj.market = it.asString
                    }

                    it.asJsonObject?.get("delegateAddress")?.let {
                        depthObj.delegateAddress = it.asString
                    }
                }


                return depthObj
            }
        }

    }
}
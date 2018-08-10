package org.loopring.looprsdk.models.ethereum

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import com.google.gson.annotations.SerializedName


import java.lang.reflect.Type
import java.math.BigInteger

class EthBlockNum {

    /**
     * Id of the response
     * TODO - find out what this is
     * Example output - 83
     */
    @SerializedName("id")
    var id: Int? = null

    /**
     * Json RPC version
     * Example output - "2.0"
     */
    @SerializedName("jsonrpc")
    var jsonrpc: String? = null

    /**
     * The block number
     * Example output - "0x4b7"
     */
    var blockNumber: BigInteger? = null

    /**
     * Custom class deserializer
     */
    class EthBlockNumDeserializer : JsonDeserializer<EthBlockNum> {
        @Throws(JsonParseException::class)
        override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): EthBlockNum? {
            if (json.isJsonNull || json.isJsonPrimitive) {
                return null
            } else {
                val blockNum = EthBlockNum()
                val blockNumJsonObject = json.asJsonObject

                //TODO - check if this code is enough to handle normally encountered errors
                blockNumJsonObject.get("id")?.let {
                    blockNum.id = it.asString.toIntOrNull()
                }

                blockNumJsonObject.get("jsonrpc")?.let {
                    blockNum.jsonrpc = it.asString
                }

                blockNumJsonObject.get("result")?.let {
                    blockNum.blockNumber = BigInteger(it.asString)
                }

                return blockNum
            }
        }

    }
}
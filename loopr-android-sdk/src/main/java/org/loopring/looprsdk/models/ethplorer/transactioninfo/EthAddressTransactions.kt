package org.loopring.looprsdk.models.ethplorer.transactioninfo

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException


import java.lang.reflect.Type

/**
 * Ethplorer API
 *
 * List of [EthAddressTransactionInfo] objects for a given address
 *
 * limit:   maximum number of operations [1 - 50, default = 10]
 *
 * showZeroValues:  show transactions with zero ETH value, default = 0
 *
 * ```
 * [
 *   {
 *     timestamp:       # operation timestamp
 *     from:            # source address (if two addresses involved),
 *     to:              # destination address (if two addresses involved),
 *     hash:            # transaction hash
 *     value:           # ETH value (as is, not reduced to a floating point value),
 *     input:           # input data
 *     success:         # true if transactions was completed, false if failed
 *   },
 * ]
 * ```
 */
class EthAddressTransactions(

        /**
         * List of [EthAddressTransactionInfo] objects for a given address
         */
        var transactions: List<EthAddressTransactionInfo>? = null
) {

    /**
     * Deserializer for [EthAddressTransactions]
     * Handles some empty strings and inconsistencies in the API responses
     */
    class EthAddressTransactionsDeserializer : JsonDeserializer<EthAddressTransactions> {
        @Throws(JsonParseException::class)
        override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): EthAddressTransactions? {
            if (json.isJsonNull || json.isJsonPrimitive) {
                return null
            }

            val jsonArray = json.asJsonArray
            val transactions = EthAddressTransactions()

            jsonArray.forEach {
                val transactionInfo: EthAddressTransactionInfo = context.deserialize(it, EthAddressTransactionInfo::class.java)
                transactions.transactions = ArrayList<EthAddressTransactionInfo>().also {
                    it.add(transactionInfo)
                }
            }

            return transactions
        }
    }
}

package org.loopring.looprsdk.models.etherscan.transactions

import com.google.gson.annotations.SerializedName


/**
 * Etherscan API
 *
 * Data about a transaction on the blockchain
 */
class TransactionResponse(

        /**
         * Status of the request. Can be 1 for complete or 0 for failure.
         */
        var status: Int? = null,

        /**
         * Status message. Can be "OK" for successful calls or "NOTOK" for failures
         */
        var message: String? = null,

        /**
         * List of results of the transaction in a [transactionList] object
         */
        @SerializedName("result")
        var transactionList: List<IndividualTransaction>? = null

)
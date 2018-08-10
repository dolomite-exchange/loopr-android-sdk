package org.loopring.looprsdk.models.ethplorer.transactioninfo




/**
 * Ethplorer API
 *
 * Logged information about a transaction
 */
class EthTransactionLogInfo(

        /**
         * Logged addresses
         */
        var address: String? = null,

        /**
         * Logged topics
         */
        var topics: List<String>? = null,

        /**
         * Logged data
         */
        var data: String? = null
)

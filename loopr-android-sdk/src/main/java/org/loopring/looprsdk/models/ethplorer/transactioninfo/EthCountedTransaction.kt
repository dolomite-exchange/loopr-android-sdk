package org.loopring.looprsdk.models.ethplorer.transactioninfo

import com.google.gson.annotations.SerializedName

import java.util.*

/**
 * Ethplorer API
 *
 * A count of the number of transactions at a given date
 *
 * ```
 * {
 *   _id: {
 *     year:  # transaction year
 *     month: # transaction month
 *     day:   # transaction day
 *   },
 *   ts:        # timestamp of the first transaction in group
 *   cnt:       # number of transaction in group
 * }
 * ```
 */
class EthCountedTransaction(

        /**
         * Object containing the year, month, and day
         */
        @SerializedName("_id")
        var transactionDate: EthTransactionDate? = null,

        /**
         * Timestamp of the transaction
         */
        @SerializedName("ts")
        var timestamp: Date? = null,

        /**
         * Count of the transactions
         */
        @SerializedName("cnt")
        var count: Long? = null
)

package org.loopring.looprsdk.models.ethplorer.eth

import com.google.gson.annotations.SerializedName
import org.loopring.looprsdk.models.ethplorer.transactioninfo.EthCountedTransaction


/**
 * Ethplorer API
 *
 * period:  show operations of specified days number only [optional, 30 days if not set, max. is 90 days]
 *
 * ```
 * {
 *   countTxs: [        # grouped token history
 *     {
 *       _id: {
 *         year:        # transaction year
 *         month:       # transaction month
 *         day:         # transaction day
 *       },
 *       ts:            # timestamp of the first transaction in group
 *       cnt:           # number of transaction in group
 *     },
 *     ...
 *   ]
 *   totals: {
 *     "tokens":        # total number of tokens listed
 *     "tokensWithPrice": # total number of tokens with price data provided
 *     "cap":           # total current market cap of tokens listed
 *     "capPrevious":   # total previous market cap of tokens listed
 *     "volume24h":     # cumulative 24 hour volume on the tokens listed
 *     "volumePrevious": # previous cumulative volume on the tokens listed
 *   }
 * }
 * ```
 */
class EthTokenHistoryGrouped(

        /**
         * A list of [EthCountedTransaction] objects that give data on the number of transactions at given days
         */
        @SerializedName("countTxs")
        var countedTransactions: List<EthCountedTransaction>? = null,

        /**
         * Cumulative transaction history data over the given time period
         */
        var totals: EthTokenHistoryTotals? = null
)

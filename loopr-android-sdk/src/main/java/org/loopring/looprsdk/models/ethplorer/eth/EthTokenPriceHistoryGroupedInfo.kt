package org.loopring.looprsdk.models.ethplorer.eth

import com.google.gson.annotations.SerializedName
import org.loopring.looprsdk.models.ethplorer.transactioninfo.EthCountedTransaction


/**
 * Ethplorer API
 *
 * Get grouped historical price data
 */
class EthTokenPriceHistoryGroupedInfo(

        /**
         * Information on the current price data related to the token
         */
        var current: EthTokenCurrentInfo? = null,

        /**
         * A list of [EthCountedTransaction] objects that count the number of transactions performed on each day
         */
        @SerializedName("countTxs")
        var countedTransactions: List<EthCountedTransaction>? = null,

        /**
         * A list of [EthTokenPriceInfo] objects that correspond to the list in [countedTransactions] and store price data
         */
        var prices: List<EthTokenPriceInfo>? = null
)
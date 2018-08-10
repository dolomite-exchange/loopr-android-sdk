package org.loopring.looprsdk.models.ethplorer.eth

import org.loopring.looprsdk.models.ethplorer.eth.EthTopTokens.Companion.SORT_CAPITALIZATION
import org.loopring.looprsdk.models.ethplorer.eth.EthTopTokens.Companion.SORT_OPERATION_COUNT
import org.loopring.looprsdk.models.ethplorer.eth.EthTopTokens.Companion.SORT_TRADE_VOLUME


/**
 * Ethplorer API
 *
 * Information about the top tokens at the time of the request
 *
 * The sorting method for the top tokens are either [SORT_TRADE_VOLUME], [SORT_CAPITALIZATION], or
 * [SORT_OPERATION_COUNT].
 */
class EthTopTokens(

        /**
         * List of token information in the form of [EthTokenInfo] objects
         */
        var tokens: List<EthTokenInfo>? = null
) {

    companion object {
        /**
         * Value to be used int he API request for sort by number of trades
         */
        const val SORT_TRADE_VOLUME = "trade"

        /**
         * Value to be used int he API request for sort by market cap
         */
        const val SORT_CAPITALIZATION = "cap"

        /**
         * Value to be used int he API request for sort by number of tokens
         */
        const val SORT_OPERATION_COUNT = "count"
    }
}

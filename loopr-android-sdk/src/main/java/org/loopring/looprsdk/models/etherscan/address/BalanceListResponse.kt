package org.loopring.looprsdk.models.etherscan.address

import com.google.gson.annotations.SerializedName


/**
 * Etherscan API
 *
 * Retrieve account balances:
 *
 * ```
 * {
 *   status
 *   message
 *   result {
 *     account
 *     balance
 *   }
 * }
 *```
 */
class BalanceListResponse(
        /**
         * Status of the request. Can be 1 for complete or 0 for failure.
         */
        var status: Int = 0,

        /**
         * Status message. Can be "OK" for successful calls or "NOTOK" for failures
         */
        var message: String? = null,

        /**
         * List of account balances in [AccountBalance] objects
         */
        @SerializedName("result")
        var balanceList: ArrayList<AccountBalance>? = null
)
